package com.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Employee;

public class EmployeeDao {

	public List<Employee> selectEmployeeList(SqlSession session, int cPage, int numPerpage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerpage,numPerpage);
		return session.selectList("employee.selectEmployeeList",null,rb);
	}

	public int selectEmployeeCount(SqlSession session) {
		return session.selectOne("employee.selectEmployeeCount");
	}

}
