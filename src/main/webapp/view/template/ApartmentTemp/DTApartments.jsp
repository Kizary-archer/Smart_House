<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<table id="tableApart" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Номер квартиры</th>
        <th>Кол.комнат</th>
        <th>Жилплощадь</th>
        <th>Дом</th>
        <th>Владелец</th>
        <th>цена за метр</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ApartmentEntity" items="${apartments}">
        <tr onclick="document.location = './viewApartment?idApartment=${ApartmentEntity.idApartment}'">
            <td><c:out value="${ApartmentEntity.idApartment}"/></td>
            <td><c:out value="${ApartmentEntity.numberApartment}"/></td>
            <td><c:out value="${ApartmentEntity.countRoom}"/></td>
            <td><c:out value="${ApartmentEntity.livingSpace}"/></td>
            <td><c:out value="${ApartmentEntity.house}"/></td>
            <td><c:out value="${ApartmentEntity.apartmentOwner}"/></td>
            <td><c:out value="${ApartmentEntity.meterPrice}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>