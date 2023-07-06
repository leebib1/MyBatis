package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmpService;
import com.mybatis.model.service.EmpServiceImpl;
import com.mybatis.model.vo.Employee;


@WebServlet("/searchEmp.do")
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService service;
    
    public SearchEmployeeServlet() {
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		String keyword=request.getParameter("keyword");
		String gender=request.getParameter("gender");
		int salary;
		try{
			salary=Integer.parseInt(request.getParameter("salary"));
		}catch(NumberFormatException e) {
			salary=0;
		}
		String salFlag=request.getParameter("salFlag");
		service=new EmpServiceImpl();
		Map param=new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		param.put("gender", gender);
		param.put("salary",salary);
		param.put("salFlag", salFlag);
		param.put("deptCodes", request.getParameterValues("deptCode"));
		param.put("jobCodes", request.getParameterValues("jobCode"));
		param.put("hireDate",request.getParameter("hireDate"));
		param.put("hireFlag", request.getParameter("hireFlag"));
		List<Employee> list=service.searchEmp(param);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/employeeList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
