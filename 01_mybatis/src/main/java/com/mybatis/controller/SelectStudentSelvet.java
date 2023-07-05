package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;


@WebServlet("/student/selectStudent.do")
public class SelectStudentSelvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectStudentSelvet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		Student s=new StudentService().selectStudent(no);
		request.setAttribute("s", s);
		request.setAttribute("count", new StudentService().selectStudentCount());
		request.getRequestDispatcher("/views/student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
