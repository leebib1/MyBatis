<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 조회 결과</title>
</head>
<body>
	<h2>학생 정보</h2>
	<c:if test="${count>0 }">
	<h3>전체 학생 수 : <c:out value="${count }"/></h3>
	</c:if>
	<c:if test="${s!=null }">
	<ul>
		<li>학생 이름 : <c:out value="${s.studentName }"/></li>
		<li>학생 전화번호 : <c:out value="${s.studentTel }"/></li>
		<li>학생 이메일 : <c:out value="${s.studentEmail }"/></li>
		<li>학생 주소 : <c:out value="${s.studentAddress }"/></li>
		<li>학생 가입일 : <c:out value="${s.reg_date }"/></li>
	</ul>
	</c:if>
	<c:if test="${students!='' }">
		<c:forEach items="${students }" var="st">
		<ul>
			<li>학생 이름 : <c:out value="${st.studentName }"/></li>
			<li>학생 전화번호 : <c:out value="${st.studentTel }"/></li>
			<li>학생 이메일 : <c:out value="${st.studentEmail }"/></li>
			<li>학생 주소 : <c:out value="${st.studentAddress }"/></li>
			<li>학생 가입일 : <fmt:formatDate value="${st.reg_date }"/></li>
		</ul>
		</c:forEach>
	</c:if>
</body>
</html>