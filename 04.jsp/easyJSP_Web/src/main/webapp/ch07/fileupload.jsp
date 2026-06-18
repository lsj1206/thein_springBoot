<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>
<body>
  <form name="fileForm" method="POST" enctype="multipart/form-data" action="fileupload_process.jsp">
    <p> 이 름 : <input type="text" name="name">
    <p> 제 목 : <input type="text" name="subject">
    <p> 파 일 : <input type="file" name="filename">
    <p> <input type="submit" value="업로드">
  </form>
</body>
</html>
