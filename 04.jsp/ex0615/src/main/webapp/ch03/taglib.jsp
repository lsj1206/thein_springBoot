<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>taglib</title>
</head>
<body>
	<c:out value="Hello, World!" />
	<c:forEach var="i" begin="1" end="12" step="3">
		<p>반복문 [${i}] step=3</p>
	</c:forEach>
</body>
</html>
