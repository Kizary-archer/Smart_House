<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<table id="tableDocumentType" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Тип документа</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="DocumentType" items="${documentTypeEntityList}">
        <tr>
            <td><c:out value="${DocumentType.idType}"/></td>
            <td><c:out value="${DocumentType.nameType}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>