<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회</title>
</head>
<body>
	<h2>사원 조회 결과</h2>
	<form action="${pageContext.request.contextPath }/searchEmp.do" method="post">
		<table>
			<tr>
				<td>
					<select name="type">
						<option value="emp_id">사원번호</option>
						<option value="emp_name">사원이름</option>
						<option value="email">이메일</option>
						<option value="phone">전화</option>
					</select>
				</td>
				<td><input type="text" name="keyword"></td>
				<td><input type="submit" value="검색"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><label><input type="radio" name="gender" value="M">남자</label></td>
				<td><label><input type="radio" name="gender" value="F">여자</label></td>
			</tr>
			<tr>
				<td>급여</td>
				<td><input type="number" name="salary" step="500000" min="1200000"></td>
				<td><label><input type="radio" name="salFlag" value="ge">이상</label></td>
				<td><label><input type="radio" name="salFlag" value="le">이하</label></td>
			</tr>
			<tr>
				<td>부서 조회</td>
				<td>
					<label><input type="checkbox" name="deptCode" value="D9">총무부</label>
					<label><input type="checkbox" name="deptCode" value="D1">인사관리부</label>
					<label><input type="checkbox" name="deptCode" value="D2">회계관리부</label>
					<label><input type="checkbox" name="deptCode" value="D3">마케팅부</label>
					<label><input type="checkbox" name="deptCode" value="D4">국내영업부</label>
					<label><input type="checkbox" name="deptCode" value="D5">해외영업1부</label>
					<label><input type="checkbox" name="deptCode" value="D6">해외영업2부</label>
					<label><input type="checkbox" name="deptCode" value="D7">해외영업3부</label>
					<label><input type="checkbox" name="deptCode" value="D8">기술지원부</label>
				</td>
			</tr>
			<tr>
				<td>직급 조회</td>
				<td>
					<label><input type="checkbox" name="jobCode" value="J1">대표</label>
					<label><input type="checkbox" name="jobCode" value="J2">부사장</label>
					<label><input type="checkbox" name="jobCode" value="J3">부장</label>
					<label><input type="checkbox" name="jobCode" value="J4">차장</label>
					<label><input type="checkbox" name="jobCode" value="J5">과장</label>
					<label><input type="checkbox" name="jobCode" value="J6">대리</label>
					<label><input type="checkbox" name="jobCode" value="J7">사원</label>
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="date" name="hireDate"></td>
				<td><label><input type="radio" name="hireFlag" value="ge">이전</label></td>
				<td><label><input type="radio" name="hireFlag" value="le">이후</label></td>
			</tr>
		</table>
	</form>
<c:choose>
	<c:when test="${empty list}">
		<h3>조회된 결과가 없습니다</h3>
	</c:when>
	<c:otherwise>
	<table class="table">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>주민번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서</th>
			<th>직급</th>
			<th>급여등급</th>
			<th>월급</th>
			<th>보너스</th>
			<th>담당 매니저</th>
			<th>입사일</th>
			<th>퇴사일</th>
			<th>퇴사여부</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${list }" var="e">
			<tr>
				<td><c:out value="${e.empId }"/></td>
				<td><c:out value="${e.empName }"/></td>
				<td><c:out value="${e.empNo }"/></td>
				<td><c:out value="${e.email }"/></td>
				<td><c:out value="${e.phone }"/></td>
				<td><c:out value="${e.deptCode }"/></td>
				<td><c:out value="${e.jobCode }"/></td>
				<td><c:out value="${e.salLevel }"/></td>
				<td><fmt:formatNumber value="${e.salary }" type="currency"/></td>
				<td><fmt:formatNumber value="${e.bonus }" type="percent"/></td>
				<td><c:out value="${e.managerId }"/></td>
				<td><c:out value="${e.hireDate }"/></td>
				<td><c:out value="${e.entDate }"/></td>
				<td><c:out value="${e.entYn }"/></td>
				<td><c:out value="${e.gender=='F'?'여':'남' }"/></td>
			</tr>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
	<div>
		${pageBar}
	</div>
</body>
</html>