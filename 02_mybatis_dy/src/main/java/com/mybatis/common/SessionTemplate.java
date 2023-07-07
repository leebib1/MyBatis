package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	public static SqlSession getSession() {
		SqlSession session=null;
		String file="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(file)){
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static SqlSession getWebSession() {
		String file="mybatis-config.xml";
		SqlSession session=null;
		try(InputStream is=Resources.getResourceAsStream(file)) {
			//원하는 id값을 매개변수로 넣으면 id값에 설정한 DB환경으로 접속할 수 있다.
			session=new SqlSessionFactoryBuilder().build(is,"web").openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
