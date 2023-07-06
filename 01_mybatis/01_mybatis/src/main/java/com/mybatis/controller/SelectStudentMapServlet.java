package com.mybatis.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;


@WebServlet("/student/selectStudentMap.do")
public class SelectStudentMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectStudentMapServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		Map data=new StudentService().selectStudentMap(no);
		System.out.println(data);
		//결과를 Map으로 받아오면서 Map의 key는 컬럼명으로 지정해서 받아온다.
		request.setAttribute("s", data);
		request.getRequestDispatcher("/views/student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
