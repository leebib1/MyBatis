package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Board;

public interface WebDao {
	Board selectBoard(SqlSession session, int no);
}
