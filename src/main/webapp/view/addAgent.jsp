<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="m-20"></div>
    <div class="w-50 m-3" >
        <form method="post">
            <h2>Агент</h2>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group col-md-4">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname">
                </div>
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="percent">Процент с продаж</label>
                    <input type="text" class="form-control" id="percent" name="percent">
                </div>
                <div class="form-group col-md-4">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
            </div>

            <button type="submit" class="btn btn-primary m-2" formaction="./addAgent">Добавить</button>
        </form>
    </div>
    <c:if test="${isAgentAdded == true}">
    <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
        <strong>Агент добавлен</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </c:if>
    <c:if test="${isAgentAdded == false}">
    <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
        <strong>Агент не добавлен</strong> Проверьте вводимые значения
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </c:if>
</div>
</body>
</html>