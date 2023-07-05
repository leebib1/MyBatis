package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	//mybatis가 제공하는 SqlSession 객체를 생성해주는 공용 메소드를 선언
	public static SqlSession getSession() {
		//SqlSession 객체를 생성하는 방법
		//1. SqlSessionFactoryBuilder 클래스의 build() 메소드를 이용해서 생성
		//1-1. SqlSessionFactoryBuilder 생성
		//1-2. build() 메소드 실행, build() 메소드의 인수로 mybatis-config.xml 파일을 전달
		//전달할 때는 Stream을 생성해서 전달한다.
		//2. SqlSessionFactory 클래스를 가져온다. ->build() 메소드가 반환함
		//2-1. openSession() 메소드를 이용한다.
		//2-2. openSession() 메소드의 인수로 true, false를 설정할 수 있다. ->autoCommit(트랜잭션)에 대한 설정
		//3. SqlSession 클래스를 가져온다. ->openSession() 메소드가 반환
		SqlSession session=null;
		String file="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(file)) {
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
