<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableAgent" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Телефон</th>
        <th>Процент</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="agent" items="${agents}">
        <tr onclick="document.location = './viewAgent?idAgent=${agent.idAgent}'">
            <td><c:out value="${agent.idAgent}"/></td>
            <td><c:out value="${agent.name}"/></td>
            <td><c:out value="${agent.surname}"/></td>
            <td><c:out value="${agent.patronymic}"/></td>
            <td><c:out value="${agent.phoneNumber}"/></td>
            <td><c:out value="${agent.percent}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>