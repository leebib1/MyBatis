package com.web.member.model.service;

import java.util.Map;

import com.web.member.model.dto.Member;

public interface MemberServiceInterface {
	Member selectMember(Map<String,Object> map);
}
