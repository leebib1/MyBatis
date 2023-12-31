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
import com.mybatis.model.service.EmployeeService;
import com.mybatis.model.vo.Employee;


@WebServlet("/memberAll.do")
public class SelectEmployeeListServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmpService service;
	
    public SelectEmployeeListServlert() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service=new EmpServiceImpl();
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(Exception e){
			cPage=1;
		}
		int numPerpage=10;
		int totalData=service.selectEmployeeCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="<ul class='pagination justify-content pagination-sm'>";
		if(pageNo==1) {
			//15버전 이상일때만 가능함
			pageBar+="""
					<li class='page-item disabled'>
					<a class='page-link' href='#'>이전</a>
					</li>
					""";
		}else {
			pageBar+="<li class='page-item'>";
			pageBar+="<a class='page-link' href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"'>이전</a></li>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<li class='page-item disabled'>";
				pageBar+="<a class='page-link' href='#'>"+pageNo+"</a></li>";
			}else {
				pageBar+="<li class='page-item'>";
				pageBar+="<a class='page-link' href='"+request.getRequestURI()+"?cPage="+(pageNo)+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			//15버전 이상일때만 가능함
			pageBar+="""
					<li class='page-item disabled'>
					<a class='page-link' href='#'>다음</a>
					</li>
					""";
		}else {
			pageBar+="<li class='page-item'>";
			pageBar+="<a class='page-link' href='"+request.getRequestURI()+"?cPage="+(pageNo+1)+"'>다음</a></li>";
		}
		pageBar+="</ul>";
		request.setAttribute("pageBar", pageBar);
		List<Employee> list=service.selectEmployeeList(cPage,numPerpage);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/employeeList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
