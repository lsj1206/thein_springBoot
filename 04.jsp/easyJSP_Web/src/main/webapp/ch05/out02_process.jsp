<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>
<body>
  <%
    request.setCharacterEncoding("UTF-8");
    String userid = request.getParameter("id");
    String password = request.getParameter("passwd");
  %>
  <p> 아이디 : <%= userid %></p>
  <p> 비밀번호 : <%= password %></p>
</body>
</html>
