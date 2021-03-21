<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, bean.News"%>
<%@ page import="java.io.PrintWriter" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<c:if test="${requestScope.message != null}">
	<c:out value="Error not correct login or password"/>
</c:if>

    <table border="2">
	    <c:forEach var="n" items="${requestScope.news}">
		<tr>
			<td>
			   <font size="18" color="blue">
			   <c:out value="${n.title}" />
			</font></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
