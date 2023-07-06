package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import com.mybatis.model.vo.Employee;

public interface EmpService {
	List<Employee> selectEmployeeList(int cPage, int numPerpage);
	
	List<Employee> searchEmp(Map<String,Object> param);
	
	int selectEmployeeCount();
}
