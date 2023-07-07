package com.mybatis.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude= {"employees"})
//ToString 오버라이딩할 때 employees는 제외 시킴
public class Department {
	private String deptId;
	private String deptTitle;
	private String locationId;
	//일대다 관계를 가질때 하나의 부서 안에 여러명의 직원이 포함될 때 객체에 list로 저장할 수 있다.
	private List<Employee> employees;
}
