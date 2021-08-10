<%--
  Created by IntelliJ IDEA.
  User: Gladkih
  Date: 02.06.2021
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css"/>
    <title>Авторизация</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>


<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="${pageContext.request.contextPath}/favicon.ico" id="icon" alt="User Icon"/>
        </div>

        <!-- Login Form -->
        <form action="<c:url value='/login'/>" method='POST'>
            <c:if test="${not empty errorMessage}">
                <div id="formHeader">
                        ${errorMessage}
                </div>
            </c:if>
            <input type="text" id="username" class="fadeIn second" name="username" placeholder="username"
                   autocomplete="username">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="password"
                   autocomplete="current-password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="<c:url value='/reg'/>">Регистрация</a>
        </div>

    </div>
</div>
</body>

</html>