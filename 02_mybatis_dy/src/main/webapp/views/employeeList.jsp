<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${list.size()>0}">
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
				<td><c:out value="${e.salary }"/></td>
				<td><c:out value="${e.bonuse }"/></td>
				<td><c:out value="${e.managerId }"/></td>
				<td><c:out value="${e.hireDate }"/></td>
				<td><c:out value="${e.entDate }"/></td>
				<td><c:out value="${e.entYn }"/></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<div>
		${pageBar}
	</div>
</body>
</html>