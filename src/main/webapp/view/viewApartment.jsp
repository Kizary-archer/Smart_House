<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="p-3">
        <h2>Квартира клиента </h2>
        <div class="w-50 p-3" >
            <form method="post" id = "formApartAdd">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="numberApartment">Номер квартиры</label>
                        <input type="text" class="form-control" id="numberApartment" name="numberApartment" placeholder="Номер квартиры" value=${apartment.numberApartment}>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="countRoom">Количество комнат</label>
                        <input type="text" class="form-control" id="countRoom" name="countRoom" placeholder="Количество комнат" value=${apartment.countRoom}>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="livingSpace">Жилплощадь</label>
                        <input type="text" class="form-control" id="livingSpace" name="livingSpace" placeholder="Жилплощадь" value=${apartment.livingSpace}>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="meterPrice">цена за кв.метр</label>
                        <input type="text" class="form-control" id="meterPrice" name="meterPrice" placeholder="цена за кв.метр" value=${apartment.meterPrice}>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="apartmentOwner">id владельца</label>
                        <input type="text" class="form-control" id="apartmentOwner" name="apartmentOwner" readonly value=${apartment.apartmentOwner}>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="house">id дома</label>
                        <input type="text" class="form-control" id="house" name="house" readonly value=${apartment.house}>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="idApartment">id квартиры</label>
                        <input type="text" class="form-control" id="idApartment" name="idApartment" readonly value=${apartment.idApartment}>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="./updApartment">Обновить</button>
                <button type="submit" class="btn btn-danger m-2" formaction="./delApartment">Удалить</button>
                <button type="reset" class="btn btn-warning m-2">Отменить</button>
            </form>
        </div>
        <c:if test="${isApartmentUpd == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Квартира изменена</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isApartmentUpd == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Квартира не изменена</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
        <c:if test="${isApartmentDel == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
                <strong>Квартира не удалена</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-success" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" id="btnAccord1" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Дом
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body" >
                    <div id = "HouseViewCard"></div>
                    <jsp:include page="template/ApartmentTemp/DTSearchHouse.jsp"/>
                </div>
            </div>
        </div>
        <div class="card" >
            <div class="card-header bg-info" id="headingThree"  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        История продаж квартиры
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
                <div class="card-body">
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
                        <c:forEach var="ApartmentSaleEntity" items="${apartment.apartmentSalesByIdApartment}">
                            <tr>
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
                </div>
            </div>
        </div>
    </div>
    </div>
</div>
<script type="text/javascript" charset="utf8">
    <%@include file='./../js/houseSelect.js' %>
</script>
<script type="text/javascript">
    $(document).ready( function () {
        $('#tableApartSale').DataTable();
    } );
</script>
</body>
</html>