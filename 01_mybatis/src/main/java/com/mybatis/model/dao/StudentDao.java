package com.mybatis.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class StudentDao {

	public int insertStudent(SqlSession session) {
		//sql문을 실행할때 session이 제공하는 메소드를 호출한다.
		//selectOne(), selectList(), insert(), update(), delete()
		//statement 인수는 "mapper태그의 namespace값.sql태그의 id값"으로 작성한다.
		int result=session.insert("student.insertStudent");
		return result;
	}

	public int insertStudentByName(SqlSession session, String name) {
		int result=session.insert("student.insertStudentByName",name);
		return result;
	}

	public int insertStudentAll(SqlSession session, Student s) {
		return session.insert("student.insertStudentAll",s);
	}

	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent",s);
	}

	public int deleteStudent(SqlSession session, int no) {
		return session.delete("student.deleteStudent",no);
	}

	public int selectStudentCount(SqlSession session) {
		//selectOne() 메소드를 이용해서 데이터를 조회할 수 있다.
		return session.selectOne("student.selectStudentCount");
	}

	public Student selectStudent(SqlSession session, int no) {
		return session.selectOne("student.selectStudent", no);
	}

	public List<Student> selectStudentAll(SqlSession session) {
		return session.selectList("student.selectStudentAll");
	}

}
