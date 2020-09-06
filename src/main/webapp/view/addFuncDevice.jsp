<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<div class="p-3">
    <div class="w-25 mx-auto" >
        <h2>Добавить функцию</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-11">
                    <label for="nameFunction">Название функции</label>
                    <input type="text" class="form-control" id="nameFunction" name="nameFunction">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="device">Устройство</label>
                    <select id="device" class="form-control" name="device">
                        <option selected value="">Выберите устройство</option>
                        <c:forEach var="dev" items="${devices}">
                            <option  value="${dev.idDevice}">${dev.nameDevice}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="typeFunction">Тип функции</label>
                    <select id="typeFunction" class="form-control" name="typeFunction" >
                        <option selected value="">Выберите тип</option>
                        <c:forEach var="type" items="${typesFunc}">
                            <option value="${type.idType}">${type.nameType}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="data">Актуальные данные</label>
                    <input type="text" class="form-control" id="data" name="data">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="minData">Мин.значение</label>
                    <input type="text" class="form-control" id="minData" name="minData">
                </div>
                <div class="form-group col-md-5">
                    <label for="maxData">Макс.значение</label>
                    <input type="text" class="form-control" id="maxData" name="maxData">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-11">
                    <label for="description">Описание</label>
                    <textarea id="description" name="description" class="form-control"></textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./addFunc">Добавить</button>
        </form>
        <c:if test="${isFuncAdded == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-12" role="alert">
                <strong>Функция добавлена</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isFuncAdded == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Функция не добавлена</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>