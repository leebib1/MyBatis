package com.web.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.member.model.dto.Member;

public interface MemberDaoInterface {
	Member selectMember(SqlSession session, Map<String,Object> map);
}
