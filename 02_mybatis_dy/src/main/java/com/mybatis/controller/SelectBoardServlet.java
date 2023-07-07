package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.WebService;
import com.mybatis.model.service.WebServiceImpl;
import com.mybatis.model.vo.Board;


@WebServlet("/board.do")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectBoardServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		WebService service=new WebServiceImpl();
		Board b=service.selectBoard(no);
		request.setAttribute("board", b);
		request.getRequestDispatcher("/views/board.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
