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
<title>Insert title here</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>핸드폰</th>
			<th>주소</th>
			<th>이메일</th>
			<th>날짜</th>
		</tr>
		<c:if test="${students.size()!=0 }">
			<c:forEach items="${students}" var="s">
				<tr>
					<td><c:out value="${s.studentNo }"/></td>
					<td><c:out value="${s.studentName }"/></td>
					<td><c:out value="${s.studentTel }"/></td>
					<td><c:out value="${s.studentAddress }"/></td>
					<td><c:out value="${s.studentEmail }"/></td>
					<td><c:out value="${s.reg_date }"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div>
		${pageBar}
		<%-- <c:out value="${pageBar }"/> --%>
	</div>
</body>
</html>