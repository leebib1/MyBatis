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
<title>게시판</title>
</head>
<body>
	<c:if test="${not empty board }">
	<table class="table">
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>이메일</th>
			<th>작성일</th>
		</tr>
		<tr>
			<td>${board.boardTitle }</td>
			<td>${board.member.userId }</td>
			<td>${board.member.email }</td>
			<td>${board.boardDate }</td>
		</tr>
		<tr>
			<td colspan="4">${board.boardContent }</td>
		</tr>
	</table>
	</c:if>
	<c:if test="${board.comments.size()>0 }">
		<table class="table">
		<c:forEach items="${board.comments }" var="c">
		<tr><th colspan="2">댓글</th></tr>
		<tr>
			<td>${c.boardCommentWriter.userId }</td>
			<td>${c.boardCommentDate }</td>
		</tr>
		<tr>
			<td colspan="2">${c.boardCommentContent }</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>