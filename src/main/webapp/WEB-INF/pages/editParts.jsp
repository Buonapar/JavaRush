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
    <title>Редактирование комплектующих</title>
</head>
<body>
    <form action="/edit" method="post">
            <table>
                <caption>Редактирование "${part.name}"</caption>
                <tr>
                    <th>Наименование</th>
                    <th>Необходимость</th>
                    <th>Количество</th>
                </tr>
                <tr>
                    <td><input type="text" value="${part.name}"></td>
                    <td>
                        <select name="necessity" id="necessity">
                            <option value="true">Да</option>
                            <option value="false">Нет</option>
                        </select>
                    </td>
                    <td><input type="text" value="${part.quantity}"></td>
                </tr>
            </table>

        <input type="submit" value="Подтвердить изменения">
    </form>
</body>
</html>
