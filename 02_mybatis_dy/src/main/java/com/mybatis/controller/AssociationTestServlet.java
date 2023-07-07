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
import com.mybatis.model.vo.Employee;

/**
 * Servlet implementation class AssociationTestServlet
 */
@WebServlet("/emp/association.do")
public class AssociationTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AssociationTestServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpServiceImpl();
		List<Employee> result=service.selectEmployeeList(1, 20);
		//result.stream().forEach(System.out::println);
		request.setAttribute("employees", result);
		request.getRequestDispatcher("/views/employees.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
