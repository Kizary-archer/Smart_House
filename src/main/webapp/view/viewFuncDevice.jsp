<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<script type="text/javascript" charset="utf8">
    <%@include file='../js/Highcharts/code/highstock.js' %>
</script>
<script type="text/javascript" charset="utf8">
    <%@include file='../js/Highcharts/code/modules/data.js' %>
</script>
<script type="text/javascript" charset="utf8">
    <%@include file='../js/Highcharts/code/modules/exporting.js' %>
</script>
<script type="text/javascript" charset="utf8">
    <%@include file='../js/Highcharts/code/modules/export-data.js' %>
</script>
<div class="p-2 d-flex">
    <div class="w-25 px-1" >
        <h2>Функция устройства</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-11">
                    <label for="nameFunction">Название функции</label>
                    <input type="text" class="form-control" id="nameFunction" name="nameFunction" value=${function.nameFunction}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="idFunction">Id</label>
                    <input readonly type="text" class="form-control" id="idFunction" name="idFunction" value=${function.idFunction}>
                </div>
                <div class="form-group col-md-8">
                    <label for="device">Устройство</label>
                    <select id="device" class="form-control" name="device">
                        <c:forEach var="dev" items="${devices}">
                            <option <c:if test="${dev.idDevice == function.device}">selected</c:if> value="${dev.idDevice}">${dev.nameDevice}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="typeFunction">Тип функции</label>
                    <select id="typeFunction" class="form-control" name="typeFunction" >
                        <c:forEach var="type" items="${typesFunc}">
                            <option <c:if test="${function.typeFunction == type.idType}">selected</c:if> value="${type.idType}">${type.nameType}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="data">Актуальные данные</label>
                    <input type="text" class="form-control" id="data" name="data" value=${function.data}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="minData">Мин.значение</label>
                    <input type="text" class="form-control" id="minData" name="minData" value=${function.minData}>
                </div>
                <div class="form-group col-md-5">
                    <label for="maxData">Макс.значение</label>
                    <input type="text" class="form-control" id="maxData" name="maxData" value=${function.maxData}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-11">
                    <label for="description">Описание</label>
                    <textarea id="description" name="description" class="form-control">${function.description}</textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./updFunc">Обновить</button>
            <button type="submit" class="btn btn-danger m-1" formaction="./delFunc">Удалить</button>
            <button type="reset" class="btn btn-warning">Отменить</button>
        </form>
        <c:if test="${isFuncupd == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-12" role="alert">
                <strong>Устройство обновлено</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isFuncupd == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Устройство не обновлено</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isFuncdel == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Устройство не удалено</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>
    <div class="w-75">
        <div id="container" style="height: 400px; min-width: 310px"></div>
        <script type="text/javascript" charset="utf8">
            <%@include file='../js/FunctionDevice.js' %>
        </script>
</div>
</div>
</body>
</html>