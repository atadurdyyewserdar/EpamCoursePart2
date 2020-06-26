<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head><title>Login</title></head>
<body><h3>Login</h3>
<hr/>
<form name="loginForm" method="POST"
      action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <input type="submit" value="Enter">
</form>
<hr/>
<br/>
</body>
</html>
