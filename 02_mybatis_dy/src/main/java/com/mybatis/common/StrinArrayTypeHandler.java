package com.mybatis.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class StrinArrayTypeHandler implements TypeHandler<String[]> {

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getString(columnName)!=null?rs.getString(columnName).split(","):null;
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getString(columnIndex)!=null?rs.getString(columnIndex).split(","):null;
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		//CallableStatement 함수 실행시 사용한다.
		return cs.getString(columnIndex)!=null?cs.getString(columnIndex).split(","):null;
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		}else{
			ps.setString(i, null);
		}
	}
	
}
