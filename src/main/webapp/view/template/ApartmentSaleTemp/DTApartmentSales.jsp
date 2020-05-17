<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableApart" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Квартира</th>
        <th>Владелец</th>
        <th>Покупатель</th>
        <th>Агент</th>
        <th>Дата продажи</th>
        <th>Цена продажи</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apartmentSale" items="${apartmentSales}">
        <tr onclick="document.location = './viewApartmentSale?idSale=${apartmentSale.idSale}'">
            <td><c:out value="${apartmentSale.idSale}"/></td>
            <td><c:out value="${apartmentSale.apartment}"/></td>
            <td><c:out value="${apartmentSale.ownerApartment}"/></td>
            <td><c:out value="${apartmentSale.buyer}"/></td>
            <td><c:out value="${apartmentSale.agent}"/></td>
            <td><c:out value="${apartmentSale.date}"/></td>
            <td><c:out value="${apartmentSale.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>