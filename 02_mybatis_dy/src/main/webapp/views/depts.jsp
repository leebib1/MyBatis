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
<title>부서</title>
</head>
<body>
	<c:if test="${not empty depts }">
		<c:forEach items="${depts }" var="d">
			<ul>
				<li>${d.deptId }</li>
				<li>${d.deptTitle }</li>
				<li>인원 수 : ${d.employees.size()}</li>
				<li>
				<c:if test="${not empty d.employees }">
					<c:forEach items="${d.employees }" var="e">
						<table>
							<tr>
								<td>${e.empName }</td>
								<td>${e.jobCode }</td>
								<td>${e.salary }</td>
							</tr>
						</table>
					</c:forEach>
				</c:if>
				</li>
			</ul>
		</c:forEach>
	</c:if>
</body>
</html>