package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;


@WebServlet("/insertStudentAll.do")
public class InsertStudentAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertStudentAllServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		Student s=Student.builder()
				.studentName(name)
				.studentTel(phone)
				.studentEmail(email)
				.studentAddress(address)
				.build();
		int result=new StudentService().insertStudentAll(s);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result>0?"<h2>성공</h2>":"<h2>실패</h2>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
