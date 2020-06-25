<%--
  Created by IntelliJ IDEA.
  User: atadu
  Date: 25.06.2020
  Time: 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Register</title></head>
<body><h3>Sign up</h3>
<hr/>
<form name="registerForm" method="POST"
      action="controller">
    <input type="hidden" name="command" value="register"/>
    FIO:<br/>
    <input type="text" name="fio" value=""><br/>
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <input type="submit" value="Enter">
</form>
<hr/>
</body>
</html>