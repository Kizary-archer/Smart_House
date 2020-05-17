<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="m-20"></div>
    <div class="w-50 p-3" >
        <h2>Добавить клиента</h2>
        <form method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Имя">
                </div>
                <div class="form-group col-md-6">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname" placeholder="Фамилия">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="patronymic">Отчество</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic" placeholder="Отчество">
                </div>
                <div class="form-group col-md-4">
                    <label for="gender">Пол</label>
                    <select id="gender" class="form-control" name="gender" >
                        <option value="" selected>Выберите пол</option>
                        <option value="true" >мужчина</option>
                        <option value="false">женщина</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="dateOfBirth">Дата Рождения</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth">
                </div>
                <div class="form-group col-md-6">
                    <label for="phoneNumber">Телефон</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"  placeholder="89994563245">
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="example@.com">
            </div>
            <button type="submit" class="btn btn-primary" formaction="./addClient">Добавить</button>
        </form>
    </div>
    <c:if test="${isClientAdded == true}">
    <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
        <strong>Клиент добавлен</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </c:if>
    <c:if test="${isClientAdded == false}">
    <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
        <strong>Клиент не добавлен</strong> Проверьте вводимые значения
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </c:if>
</div>
</body>
</html>