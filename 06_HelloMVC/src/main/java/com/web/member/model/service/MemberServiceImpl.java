package com.web.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.web.member.dao.MemberDaoImpl;
import com.web.member.dao.MemberDaoInterface;
import com.web.member.model.dto.Member;
import static com.web.common.SessionTemplate.*;

import java.util.Map;

public class MemberServiceImpl implements MemberServiceInterface {
	private MemberDaoInterface dao=new MemberDaoImpl();
	
	@Override
	public Member selectMember(Map<String,Object> map) {
		SqlSession session=getSession();
		Member loginMember=dao.selectMember(session, map);
		session.close();
		return loginMember;
	}
}
