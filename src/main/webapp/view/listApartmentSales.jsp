<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div>
    <div class="p-3">
        <h2>Поиск продаж</h2>
        <div class="w-50 p-3" >
            <form method="post" id = "formApartAdd">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="apartment">Квартира</label>
                        <input type="text" class="form-control" id="apartment" name="apartment">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ownerApartment">Владелец </label>
                        <input type="text" class="form-control" id="ownerApartment" name="ownerApartment" >
                    </div>
                    <div class="form-group col-md-4">
                        <label for="buyer">Покупатель</label>
                        <input type="text" class="form-control" id="buyer" name="buyer" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="agent">Агент</label>
                        <input type="text" class="form-control" id="agent" name="agent" >
                    </div>
                    <div class="form-group col-md-3">
                        <label for="date">Дата продажи</label>
                        <input type="date" class="form-control" id="date" name="date">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="price">Цена продажи</label>
                        <input type="text" class="form-control" id="price" name="price">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="idSale">id продажи</label>
                        <input type="text" class="form-control" id="idSale" name="idSale">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="./listApartmentSales">Найти</button>
            </form>
        </div>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" id="btnAccord1" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Список сделок по продаже
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body" >
                    <jsp:include page="template/ApartmentSaleTemp/DTApartmentSales.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>

    <script type="text/javascript">
        $(document).ready( function () {
            $('#tableApart').DataTable();
        } );
    </script>
</body>
</html>