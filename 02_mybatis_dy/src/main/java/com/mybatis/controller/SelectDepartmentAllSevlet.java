package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmpService;
import com.mybatis.model.service.EmpServiceImpl;
import com.mybatis.model.vo.Department;


@WebServlet("/selectDeptAll.do")
public class SelectDepartmentAllSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectDepartmentAllSevlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpServiceImpl();
		List<Department> depts=service.selectAllDept();
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("/views/depts.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
