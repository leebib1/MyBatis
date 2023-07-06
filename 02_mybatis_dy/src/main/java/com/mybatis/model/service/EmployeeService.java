package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmployeeDao;
import com.mybatis.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao=new EmployeeDao();
	public List<Employee> selectEmployeeList(int cPage, int numPerpage) {
		SqlSession session=getSession();
		List<Employee> list=dao.selectEmployeeList(session, cPage, numPerpage);
		session.close();
		return list;
	}
	public int selectEmployeeCount() {
		SqlSession session=getSession();
		int count=dao.selectEmployeeCount(session);
		session.close();
		return count;
	}
	
}
