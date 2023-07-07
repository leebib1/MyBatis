package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Department;
import com.mybatis.model.vo.Employee;

public interface EmpDao {
	List<Employee> selectEmployeeList(SqlSession session, int cPage, int numPerpage);
	
	List<Employee> searchEmp(SqlSession session, Map<String,Object> param);

	int selectEmployeeCount(SqlSession session);
	
	List<Department> selectAllDept(SqlSession session);
}
