<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableApart" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Телефон</th>
        <th>Email</th>
        <th>Пол</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr onclick="document.location = './viewClient?idClient=${client.idClient}'">
            <td><c:out value="${client.idClient}"/></td>
            <td><c:out value="${client.name}"/></td>
            <td><c:out value="${client.surname}"/></td>
            <td><c:out value="${client.patronymic}"/></td>
            <td><c:out value="${client.dateOfBirth}"/></td>
            <td><c:out value="${client.phoneNumber}"/></td>
            <td><c:out value="${client.email}"/></td>
            <td><c:out value="${client.gender}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>