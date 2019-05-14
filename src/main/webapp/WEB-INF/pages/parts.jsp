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
    <c:url value="/" var="home"/>
    <form method="get" action="${home}">
        <input type="hidden" name="page" value="${page}">
        <button type="submit" name="importance" value="1" > Все</button>
        <button type="submit" name="importance" value="2">Необходимые</button>
        <button type="submit" name="importance" value="3">Опциональные</button>
<%--        <input type="submit" value="Сортировать">--%>
    </form>
    <table border="1">
        <c:if test="${importance eq 1}">
            <caption>Список всех комплектующих (${partCount} позиций)</caption>
        </c:if>
        <c:if test="${importance eq 2}">
            <caption>Комплектующие необходимые для сборки (${partsList.size()} позиций)</caption>
        </c:if>
        <c:if test="${importance eq 3}">
            <caption>Комплектующие опциональные (${partsList.size()} позиций)</caption>
        </c:if>
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
                <td><a href="/delete/${part.id}">Удаление</a> </td>
            </tr>
        </c:forEach>
        <c:if test="${importance eq 1}">
        <tr>
            <th>Можно собрать</th>
            <th>${countPC}</th>
            <th>компьютеров</th>
        </tr>
        </c:if>
    </table>
    <c:if test="${importance eq 1}">
    <b>Страницы: </b>
    <c:forEach begin="1" end="${pageCount}" step="1" varStatus="i">
        <c:url value="/" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a class="tf" href="${url}">${i.index}</a>
    </c:forEach>
    </c:if>
    <c:url value="/add" var="add"/>
    <a href="${add}">Добавить комплектующие</a><br>

    <c:url value="/search" var="search"/>
    <form name="name" method="get" action="${search}">
        <input type="text" size="20" name="name" value="">
        <input type="submit" value="Найти по наименованию">
    </form>
</body>
</html>
