<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableApartSale" class="display">
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
    <c:forEach var="ApartmentSaleEntity" items="${agent.apartmentSalesByIdAgent}">
        <tr onclick="document.location = './viewApartmentSale?idSale=${ApartmentSaleEntity.idSale}'">
            <td><c:out value="${ApartmentSaleEntity.idSale}"/></td>
            <td><c:out value="${ApartmentSaleEntity.apartment}"/></td>
            <td><c:out value="${ApartmentSaleEntity.ownerApartment}"/></td>
            <td><c:out value="${ApartmentSaleEntity.buyer}"/></td>
            <td><c:out value="${ApartmentSaleEntity.agent}"/></td>
            <td><c:out value="${ApartmentSaleEntity.date}"/></td>
            <td><c:out value="${ApartmentSaleEntity.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>