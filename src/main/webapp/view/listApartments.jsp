<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="p-3">
        <h2>Список квартир</h2>
        <div class="w-50 p-3" >
            <form method="post" id = "formApartAdd">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="numberApartment">Номер квартиры</label>
                        <input type="text" class="form-control" id="numberApartment" name="numberApartment" placeholder="Номер квартиры">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="countRoom">Количество комнат</label>
                        <input type="text" class="form-control" id="countRoom" name="countRoom" placeholder="Количество комнат" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="livingSpace">Жилплощадь</label>
                        <input type="text" class="form-control" id="livingSpace" name="livingSpace" placeholder="Жилплощадь">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="meterPrice">цена за кв.метр</label>
                        <input type="text" class="form-control" id="meterPrice" name="meterPrice" placeholder="цена за кв.метр" >
                    </div>
                    <div class="form-group col-md-3">
                        <label for="idApartment">id квартиры</label>
                        <input type="text" class="form-control" id="idApartment" name="idApartment" >
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="./listApartments">Найти</button>
            </form>
        </div>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" id="btnAccord1" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Список квартир
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body" >
                    <div id = "HouseViewCard"></div>
                    <jsp:include page="template/ApartmentTemp/DTApartments.jsp"/>
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
            $('#tableApart').DataTable();
        } );
    </script>
</body>
</html>