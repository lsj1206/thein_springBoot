<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>
<body>
  <%
    out.println("오늘의 날짜 및 시각" + "<br>");
    out.println(java.util.Calendar.getInstance().getTime());
  %>
</body>
</html>
