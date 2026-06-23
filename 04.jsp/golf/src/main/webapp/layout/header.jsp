<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>골프연습장 회원관리 프로그램 ver 1.0</header>
<nav>
<ul>
	<li><a href="${pageContext.request.contextPath}/golf?action=teacher">강사조회</a></li>
	<li><a href="${pageContext.request.contextPath}/golf?action=insert">수강신청</a></li>
	<li><a href="${pageContext.request.contextPath}/golf?action=member">회원정보조회</a></li>
	<li><a href="${pageContext.request.contextPath}/golf?action=result">강사매출현황</a></li>
	<li><a href="${pageContext.request.contextPath}/index.jsp">홈으로</a></li>
</ul>
</nav>
</body>
</html>
