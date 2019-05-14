<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.05.2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty part.name}">
        <title>Редактирование комплектующих</title>
    </c:if>
    <c:if test="${!empty part.name}">
        <title>Добавление нового комплектующего</title>
    </c:if>
    <style>
        table, body{
            text-align: center;
        }
        table {
            margin: auto;
        }
    </style>
</head>
<body>
    <c:if test="${empty part.name}">
        <c:url value="/add" var="var"/>
    </c:if>
    <c:if test="${!empty part.name}">
        <c:url value="/edit" var="var"/>
    </c:if>
    <h1><a href="/">Склад деталей</a></h1>
        <form action="${var}" method="post">
        <c:if test="${!empty part.name}">
            <input type="hidden" name="id" value="${part.id}">
        </c:if>
        <table border="1">
            <c:if test="${empty part.name}">
                <caption>Добавление нового комплектующего</caption>
            </c:if>
            <c:if test="${!empty part.name}">
                <caption>Редактирование "${part.name}"</caption>
            </c:if>
            <tr>
                <th>Наименование</th>
                <th>Необходимость</th>
                <th>Количество</th>
            </tr>
            <tr>
                <td><label>
                    <input type="text" name="name" value="${part.name}">
                </label></td>
                <td>
                    <select name="necessity">
                        <option value="true">Да</option>
                        <option value="false">Нет</option>
                    </select>
                </td>
                <td><label>
                    <input type="text" name="quantity" value="${part.quantity}">
                </label></td>
            </tr>
        </table>
        <c:if test="${empty part.name}">
            <input type="submit" value="Добавить комплектующее">
        </c:if>
        <c:if test="${!empty part.name}">
            <input type="submit" value="Подтвердить изменения">
        </c:if>
    </form>
</body>
</html>
