<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 m-3" >
        <form method="post">
            <h2>Агент</h2>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" value=${agent.name}>
                </div>
                <div class="form-group col-md-4">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname" value=${agent.surname}>
                </div>
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic" value=${agent.patronymic}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="percent">Процент с продаж</label>
                    <input type="text" class="form-control" id="percent" name="percent" value=${agent.percent}>
                </div>
                <div class="form-group col-md-4">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=${agent.phoneNumber}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idAgent">id</label>
                    <input type="text" class="form-control" id="idAgent" name="idAgent" readonly value=${agent.idAgent}>
                </div>
            </div>
            <button type="submit" class="btn btn-primary m-2" formaction="./updAgent">Обновить</button>
            <button type="submit" class="btn btn-danger m-2" formaction="./delAgent">Удалить</button>
            <button type="button" class="btn btn-success m-2" onclick="document.location = './addAgent'">Добавить</button>
            <button type="reset" class="btn btn-warning m-2">Отменить</button>
        </form>
    </div>

    <c:if test="${isAgentUpd == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Данные агента обновлены</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isAgentUpd == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Данные агента не обновлены</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isAgentdel == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Агент не удалён</strong> Проверьте вводимые значения
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
                        Проданные квартиры
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/AgentTempl/DTApartSaleAgent.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#tableApartSale').DataTable();
    } );
    </script>
</body>
</html>