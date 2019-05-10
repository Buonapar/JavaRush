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
                <td>${i.index + 1 + (page - 1) * 10}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
