<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 p-3" >
        <h2>Документ клиента</h2>
        <form method="post">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="series">Серия</label>
                    <input type="text" class="form-control" id="series" name="series" value=${documentClient.series}>
                </div>
                <div class="form-group col-md-6">
                    <label for="number">Номер</label>
                    <input type="text" class="form-control" id="number" name="number" value=${documentClient.number}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idDocument">id</label>
                    <input type="text" class="form-control" id="idDocument" name="idDocument" readonly value=${documentClient.idDocument}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="issued">Выдан:</label>
                    <input type="text" class="form-control" id="issued" name="issued" value=${documentClient.issued}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfIssue">Дата выдачи</label>
                    <input type="date" class="form-control" id="dateOfIssue" name="dateOfIssue" value=${documentClient.dateOfIssue}>
                </div>
                <div class="form-group col-md-3">
                    <label for="client">id клиента</label>
                    <input type="text" class="form-control" id="client" name="client" readonly value=${documentClient.client}>
                </div>
                <div class="form-group col-md-3">
                    <label for="typeDocument">id типа документа</label>
                    <input type="text" class="form-control" id="typeDocument" name="typeDocument" readonly value=${documentClient.typeDocument}>
                </div>
            </div>
            <button type="submit" class="btn btn-primary m-2" formaction="./updDocument">Обновить</button>
            <button type="submit" class="btn btn-danger m-2" formaction="./delDocument">Удалить</button>
            <button type="reset" class="btn btn-warning m-2">Отменить</button>
        </form>
    </div>
    <c:if test="${isDocumentUpd == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ обновлён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isDocumentUpd == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ не обновлён</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isDocumentdel == false}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ не удалён</strong> Проверьте вводимые значения
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" id="btnAccord1" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Тип документа
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/DocumentTempl/DTDocumentType.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf8">
    <%@include file='./../js/documentTypeSelect.js' %>
</script>
</body>
</html>