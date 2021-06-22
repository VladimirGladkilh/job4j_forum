<%--
  Created by IntelliJ IDEA.
  User: Gladkih
  Date: 18.04.2021
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<form action="<c:url value='/save?id=${post.id}'/>" method='POST'>
    <table>
        <tr>
            <td>Тема:</td>
            <td><input type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>Содержание:</td>
            <td><input type='text' name='description' value="${post.description}"></td>
        </tr>

        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
        </tr>
    </table>
</form>
</body>
</html>