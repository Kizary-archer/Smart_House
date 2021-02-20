<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableDocum" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Серия</th>
        <th>Номер</th>
        <th>Выдан</th>
        <th>Дата выдачи</th>
        <th>Тип документа</th>
        <th>Клиент</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="DocumentsClientEntity" items="${client.documentsClientsByIdClient}">
        <tr onclick="document.location = './viewDocument?idDocument=${DocumentsClientEntity.idDocument}'">
            <td><c:out value="${DocumentsClientEntity.idDocument}"/></td>
            <td><c:out value="${DocumentsClientEntity.series}"/></td>
            <td><c:out value="${DocumentsClientEntity.number}"/></td>
            <td><c:out value="${DocumentsClientEntity.issued}"/></td>
            <td><c:out value="${DocumentsClientEntity.dateOfIssue}"/></td>
            <td><c:out value="${DocumentsClientEntity.typeDocument}"/></td>
            <td><c:out value="${DocumentsClientEntity.client}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>