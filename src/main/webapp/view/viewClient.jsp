<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 m-3" >
        <form method="post">
            <h2>Информация о клиенте</h2>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" value=${client.name}>
                </div>
                <div class="form-group col-md-6">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname" value=${client.surname}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic" value=${client.patronymic}>
                </div>
                <div class="form-group col-md-4">
                    <label for="gender">Пол</label>
                    <select id="gender" class="form-control" name="gender">
                        <option <c:if test="${client.gender == true}">selected</c:if> value="true" >
                            мужчина
                        </option>
                        <option <c:if test="${client.gender == false}">selected</c:if> value="false">
                            женщина
                        </option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfBirth">Дата Рождения</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" value=${client.dateOfBirth}>
                </div>
                <div class="form-group col-md-6">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=${client.phoneNumber}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idClient">id</label>
                    <input type="text" class="form-control" id="idClient" name="idClient" value = ${client.idClient} readonly>
                </div>
            </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value=${client.email}>
                </div>
            <button type="submit" class="btn btn-primary m-2" formaction="./updClient">Обновить</button>
            <button type="submit" class="btn btn-danger m-2" formaction="./delClient">Удалить</button>
            <button type="button" class="btn btn-success m-2" onclick="document.location = './addClient'">Добавить</button>
            <button type="reset" class="btn btn-warning m-2">Отменить</button>
        </form>
    </div>

    <c:if test="${isClientUpd == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Данные клиента обновлены</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isClientUpd == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Данные клиента не обновлены</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isClientdel == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Клиент не удалён</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Документы клиента
                    </button>
                    <button class="btn mx-3" type="button" onclick="document.location = './addDocument?idClient=${client.idClient}'">
                       Добавить документы клиента
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTDocumentsClient.jsp"/>
                    </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header bg-success" id="headingTwo"  data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Квартиры клиента
                    </button>
                    <button class="btn mx-3" type="button" onclick="document.location = './addApartment?idClient=${client.idClient}'">
                        Добавить квартиру клиенту
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse multi-collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTApartClient.jsp"/>
                </div>
            </div>
        </div>
        <div class="card" >
            <div class="card-header bg-info" id="headingThree"  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h5 class="mb-0">
                    <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Сделки по продаже квартир
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/ClientTempl/DTApartSaleClient.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#tableApart,#tableDocum,#tableApartSale').DataTable();
    } );
    </script>
</body>
</html>