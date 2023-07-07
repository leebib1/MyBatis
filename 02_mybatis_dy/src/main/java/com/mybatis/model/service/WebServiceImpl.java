package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getWebSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.WebDao;
import com.mybatis.model.dao.WebDaoImpl;
import com.mybatis.model.vo.Board;
public class WebServiceImpl implements WebService {
	private WebDao dao=new WebDaoImpl();
	@Override
	public Board selectBoard(int no) {
		SqlSession session=getWebSession();
		Board b=dao.selectBoard(session, no);
		session.close();
		return b;
	}
}
