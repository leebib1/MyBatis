package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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

	public List<Student> selectStudentByName(SqlSession session, String name) {
		return session.selectList("student.selectStudentByName", name);
	}

	public Map selectStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectStudentMap",no);
	}

	public List<Map> selectStudentListMap(SqlSession session) {
		return session.selectList("student.selectStudentListMap");
	}

	public List<Student> selectStudentPage(SqlSession session, int cPage, int numPerpage) {
		//MyBatis에서 paging처리
		//MyBatis가 제공하는 페이징처리 객체를 이용한다.
		//RowBounds 클래스를 이용
		//selectList 호출 시 세번째 매개변수에 RowBounds 클래스를 생성해서 전달해준다.
		//매개변수 있는 생성자를 이용해서 객체 생성
		//1. 매개변수 : offset 시작 번호 (cPage-1)*numPerpage
		//2. 매개변수 : 범위. numPerpage
		RowBounds rb=new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("student.selectStudentPage", null, rb); //매개변수 순서 맞춰야함
	}

}
