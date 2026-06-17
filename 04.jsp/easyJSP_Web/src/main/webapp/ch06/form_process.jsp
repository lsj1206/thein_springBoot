<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Form Processing</title>
</head>
<body>
  <%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("passwd");
    String name = request.getParameter("name");
    String phone1 = request.getParameter("phone1");
    String phone2 = request.getParameter("phone2");
    String phone3 = request.getParameter("phone3");
    String sex = request.getParameter("sex");
    String[] hobby = request.getParameterValues("hobby");
    String comment = request.getParameter("comment");
  %>
  <p> 아이디 : <%=id %>
  <p> 비밀번호 : <%=pwd %>
  <p> 이름 : <%=name %>
  <p> 연락처 : <%=phone1 %> - <%=phone2 %> - <%=phone3 %>
  <p> 성별 : <%=sex %>
  <p> 취미 : <% for (int i = 0; i < hobby.length; i++) { %><%=hobby[i] %><% } %>
  <p> 가입 인사 : <%=comment %>
</body>
</html>
