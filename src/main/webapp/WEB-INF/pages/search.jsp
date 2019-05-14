<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 13.05.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Результаты поиска</title>
</head>
<body>
<table border="1">
    <caption>Список комплектующих найденных по запросу "${query}"</caption>
    <tr>
        <th>Наименование</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    <c:forEach var="part" items="${searchParts}" varStatus="i">
    <tr>
        <td>${part.name}</td>
        <td>
            <c:if test="${part.necessity}">Да</c:if>
            <c:if test="${!part.necessity}">Нет</c:if>
        </td>
        <td>${part.quantity}</td>
        <td><a href="/edit/${part.id}">Редактировать</a> </td>
        <td><a href="/delete/${part.id}">Удаление</a> </td>
    </tr>
    </c:forEach>
    <c:url value="/" var="home"/>
    <a href="${home}">Вернуться к списку</a>
</table>
</body>
</html>
