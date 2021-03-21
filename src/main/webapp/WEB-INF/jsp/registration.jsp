<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:bundle basename="content">
		<fmt:message key="register.glofh" var="gui"/>
	</fmt:bundle>
<title>Insert title here</title>
	<link rel="stylesheet" href="<c:url value="/css/registration.css"/>" type="text/css"/>
</head>
<body>
<jsp:include page="../jsp/header.jsp"/>
<form action="Controller" method="post">
	<div class="container">
		<h1></h1>
		<p>Please fill in this form to create an account.</p>
		<hr>

		<label for="login"><b>Login</b></label>
		<input type="text" placeholder="Enter Login" name="login" id="login" required>

		<label for="password"><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="password" id="password" required>
		<hr>
		<input type="hidden" name="command" value="registration"/>
		<button type="submit" class="registerbtn">Register</button>
	</div>

	<div class="container signin">
		<p>Already have an account? <a href="Controller?command=gotologinpage">Sign in</a></p>
	</div>
</form>
</body>
</html>