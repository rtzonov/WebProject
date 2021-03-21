<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/header.css"/>" type="text/css">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:bundle basename="content">
        <fmt:message key="header.language" var="language"/>
        <fmt:message key="header.restaurant" var="restaurant"/>
        <fmt:message key="header.title" var="title"/>
        <fmt:message key="header.log_in" var="log_in"/>
        <fmt:message key="header.sign_up" var="sign_up"/>
        <fmt:message key="header.menu" var="menu"/>
        <fmt:message key="header.news" var="news"/>
        <fmt:message key="header.ru" var="ru"/>
        <fmt:message key="header.en" var="en"/>
    </fmt:bundle>
    <title>Title</title>
</head>
<body>
<div id="header" class="tabcontent">
    <h1>${restaurant}</h1>
    <p>${title}</p>
</div>
<div class="navigation">
    <a class="tablink" href="Controller?command=gotomenupage">${menu}</a>
    <a class="tablink" href="Controller?command=gotonewspage">${news}</a>

    <a class="tablink" href="Controller?command=gotologinpage">${log_in}</a>
    <a class="tablink" href="Controller?command=gotoregistrationpage">${sign_up}</a>

    <a class="navigation">
        <ul class="topmenu">
            <li><a href="#">${language}<i class="fa fa-angle-down"></i></a>
                <ul class="submenu">
                    <li><a href="Controller?command=changelang&locale=en">${en}</a></li>
                    <li><a href="Controller?command=changelang&locale=ru">${ru}</a></li>
                </ul>
            </li>
        </ul>

    </a>

</div>



</body>
</html>
