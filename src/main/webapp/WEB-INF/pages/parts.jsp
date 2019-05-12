<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.05.2019
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список комплектующих</title>
</head>
<body>
    <table>
        <caption>Список комплектующих</caption>
        <tr>
            <th>Наименование</th>
            <th>Необходимость</th>
            <th>Количество</th>
        </tr>
        <c:forEach var="part" items="${partsList}" varStatus="i">
            <tr>
                <td>${part.name}</td>
                <td>
                    <c:if test="${part.necessity}">Да</c:if>
                    <c:if test="${!part.necessity}">Нет</c:if>
                </td>
                <td>${part.quantity}</td>
                <td><a href="/edit/${part.id}">Редактировать</a> </td>
            </tr>
        </c:forEach>
        <tr>
            <th>Можно собрать</th>
<%--            <th>${countPC}</th>--%>
            <th>компьютеров</th>
        </tr>
    </table>
    <b>Страницы: </b>
    <c:forEach begin="1" end="${pageCount}" step="1" varStatus="i">
        <c:url value="/" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a class="tf" href="${url}">${i.index}</a>
    </c:forEach>
</body>
</html>
