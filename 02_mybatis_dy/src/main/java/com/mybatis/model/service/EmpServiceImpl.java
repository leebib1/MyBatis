package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmpDao;
import com.mybatis.model.dao.EmpDaoImpl;
import com.mybatis.model.vo.Department;
import com.mybatis.model.vo.Employee;

public class EmpServiceImpl implements EmpService {
	private EmpDao dao=new EmpDaoImpl();

	@Override
	public List<Employee> selectEmployeeList(int cPage, int numPerpage) {
		SqlSession session=getSession();
		List<Employee> list=dao.selectEmployeeList(session, cPage, numPerpage);
		session.close();
		return list;
	}

	@Override
	public List<Employee> searchEmp(Map<String, Object> param) {
		SqlSession session=getSession();
		List<Employee> list=dao.searchEmp(session, param);
		session.close();
		return list;
	}

	@Override
	public int selectEmployeeCount() {
		SqlSession session=getSession();
		int count=dao.selectEmployeeCount(session);
		session.close();
		return count;
	}

	@Override
	public List<Department> selectAllDept() {
		SqlSession session=getSession();
		List<Department> list=dao.selectAllDept(session);
		session.close();
		return list;
	}
}
