<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<div class="accordion mx-auto " id="accordion" style="width: 80%;">
    <div class="card">
        <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
            <h5 class="mb-0">
                <button id="btnUserList" class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    Список пользователей
                </button>
            </h5>
        </div>

        <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
            <div class="card-body">
                <div class="m-3" >
                    <form method="post" id = "formUserView">
                        <h2>Список Пользователей</h2>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="login">Логин</label>
                                <input type="text" class="form-control" id="login" name="login">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="statusName">Статус</label>
                                <input type="text" class="form-control" id="statusName" name="statusName">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="nameRole">Роль</label>
                                <input type="text" class="form-control" id="nameRole" name="nameRole">
                            </div>

                            <div class="form-group col-md-2">
                                <label for="idUser">id Пользователя</label>
                                <input type="text" class="form-control" id="idUser" name="idUser">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary m-2" >Найти</button>
                    </form>
                </div>
                <table id="DTUserView" class="display">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Логин</th>
                        <th>Дата регистрации</th>
                        <th>Статус</th>
                        <th>Роль</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header bg-success" id="headingTwo"  data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
            <h5 class="mb-0">
                <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Покупатель
                </button>
            </h5>
        </div>
        <div id="collapseTwo" class="collapse multi-collapse" aria-labelledby="headingTwo" data-parent="#accordion">
            <div class="card-body">
                <table id="DTClient" class="display">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Отчество</th>
                        <th>Дата рождения</th>
                        <th>Телефон</th>
                        <th>Email</th>
                        <th>Пол</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div class="card" >
        <div class="card-header bg-info" id="headingThree"  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
            <h5 class="mb-0">
                <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Агент
                </button>
            </h5>
        </div>
        <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
            <div class="card-body">
                <div class="w-50 m-3" >
                    <form method="post" id = "formAgent">
                        <h2>Список агентов</h2>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="Aname">Имя</label>
                                <input type="text" class="form-control" id="Aname" name="Aname">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="Asurname">Фамилия</label>
                                <input type="text" class="form-control" id="Asurname" name="Asurname">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="Apatronymic">Отчество</label>
                                <input type="text" class="form-control" id="Apatronymic" name="Apatronymic">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="Apercent">Процент с продаж</label>
                                <input type="text" class="form-control" id="Apercent" name="Apercent">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="AphoneNumber">Телефон</label>
                                <input type="text" class="form-control" id="AphoneNumber" name="AphoneNumber">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="idAgent">id Агента</label>
                                <input type="text" class="form-control" id="idAgent" name="idAgent">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary m-2" >Найти</button>
                    </form>
                </div>
                <table id="DTAgent" class="display">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Отчество</th>
                        <th>Процент</th>
                        <th>Телефон</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" charset="utf8">
    <%@include file='./../js/multiSelect.js' %>
</script>
</html>
