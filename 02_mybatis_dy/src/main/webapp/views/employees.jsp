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
<title>객체 조회 결과</title>
</head>
<body>
	<c:if test="${not empty employees }">
	<table class="table">
		<c:forEach var="e" items="${employees }">
			<tr>
				<td><c:out value="${e.empId }"/></td>
				<td><c:out value="${e.empName }"/></td>
				<td><c:out value="${e.empNo }"/></td>
				<td><c:out value="${e.email }"/></td>
				<td><c:out value="${e.phone }"/></td>
				<td>
					<ul>
						<li><c:out value="${e.dept.deptId }"/></li>
						<li><c:out value="${e.dept.deptTitle }"/></li>
						<li><c:out value="${e.dept.locationId }"/></li>
					</ul>
				</td>
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
	</c:if>
</body>
</html>