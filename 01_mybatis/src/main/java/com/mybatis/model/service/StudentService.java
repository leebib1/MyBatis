package com.mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SessionTemplate;
import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.vo.Student;

import static com.mybatis.common.SessionTemplate.*;

import java.util.List;

public class StudentService {
	private StudentDao dao=new StudentDao();
	
	public int insertStudent() {
		SqlSession session=SessionTemplate.getSession();
		//System.out.println(session);
		int result=dao.insertStudent(session);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public int insertStudentByName(String name) {
		SqlSession session=getSession();
		int result=dao.insertStudentByName(session, name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public int insertStudentAll(Student s) {
		SqlSession session=getSession();
		int result=dao.insertStudentAll(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public int updateStudent(Student s) {
		SqlSession session=getSession();
		int result=dao.updateStudent(session, s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public int deleteStudent(int no) {
		SqlSession session=getSession();
		int result=dao.deleteStudent(session, no);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public int selectStudentCount() {
		SqlSession session=getSession();
		int count=dao.selectStudentCount(session);
		session.close();
		return count;
	}

	public Student selectStudent(int no) {
		SqlSession session=getSession();
		Student s=dao.selectStudent(session, no);
		session.close();
		return s;
	}

	public List<Student> selectStudentAll() {
		SqlSession session=getSession();
		List<Student> list=dao.selectStudentAll(session);
		session.close();
		return list;
	}

}
