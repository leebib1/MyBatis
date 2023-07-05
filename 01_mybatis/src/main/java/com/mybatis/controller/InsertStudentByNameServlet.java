package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;


@WebServlet("/insertStudentByName.do")
public class InsertStudentByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertStudentByNameServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int result=new StudentService().insertStudentByName(name);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(result>0?"성공":"실패");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
