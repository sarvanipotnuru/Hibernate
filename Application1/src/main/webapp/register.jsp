<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@ include file = "Bootstrap.jsp" %>
</head>
<body>

<%--<%@ %> importing packages
<% %> for import java
<%= %> for output
  comment --%>
  
  <%-- form tag used because to connect backend with html, post for security --%>
  <form action=" toconnect" method = "post">
  <input type = "text" placeholder="enter name" class = "form-control" name="name">
  <input type = "email" placeholder="enter email" class = "form-control" name="email">
  <input type = "password" placeholder="password" class = "form-control" name="password">
  <button type = "submit">register</button>
  </form>

</body>
</html>