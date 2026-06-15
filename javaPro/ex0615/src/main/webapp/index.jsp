<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    JSP script
    <%!
      int count = 3;
      String makeItLower(String data) {
        return data.toLowerCase();
      } %>

      <%
      for (int i = 0; i < count; i++) {
        out.println("Hello " + i + "<br>");
      }
      %>

      <%= makeItLower("Hello World")%>
  </body>
</html>
