<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 14.03.2021
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>" type="text/css"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<form action="Controller" method="post">
    <div class="container">
        <h1>Log in</h1>
        <p>Please fill in this form to log in.</p>
        <hr>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" name="login" id="login" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>
        <hr>
        <input type="hidden" name="command" value="logination"/>
        <button type="submit" class="loginbtn">log in</button>
    </div>
   	<div class="container signin">
		<p>If you don't have an account yet register it <a href="Controller?command=gotoregistrationpage">right now</a></p>
	</div>
</form>

	<br />
</body>
</html>
