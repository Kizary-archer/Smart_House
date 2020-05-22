<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<div class="accordion mx-auto " id="accordion" style="width: 90%;">
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
                        <h2>Сортировка пользователей</h2>
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
                        <button type="submit" class="btn btn-primary m-2" id="btnUserFilter">Найти</button>
                        <a href="./addUser" type="button" class="btn btn-primary m-2" id="btnUserAdd">Добавить</a>
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
                    Список пользовательских ролей
                </button>
            </h5>
        </div>
        <div id="collapseTwo" class="collapse multi-collapse" aria-labelledby="headingTwo" data-parent="#accordion">
            <div class="card-body">
                <div class="m-3" >
                    <form method="post" id = "formUserRole">
                        <h2>Сортировка пользовательских ролей</h2>
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="idRole">Id роли</label>
                                <input type="text" class="form-control" id="idRole" name="idRole">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="RnameRole">Имя роли</label>
                                <input type="text" class="form-control" id="RnameRole" name="RnameRole">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary m-2" id="btnUserRoleFilter">Найти</button>
                    </form>
                </div>
                <table id="DTUserRoleView" class="display">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Имя роли</th>
                        <th>Описание</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header bg-info" id="headingThree"  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
            <h5 class="mb-0">
                <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Список событий
                </button>
            </h5>
        </div>
        <div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
            <div class="card-body">
                <div class="m-3" >
                    <form method="post" id = "formJournalEventView">
                        <h2>Сортировка списка событий</h2>
                        <div class="form-row">
                            <div class="form-group col-md-1">
                                <label for="idEvent">Id события</label>
                                <input type="text" class="form-control" id="idEvent" name="idEvent">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="nameEvent">Имя события</label>
                                <input type="text" class="form-control" id="nameEvent" name="nameEvent">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="nameFunction">Имя функции</label>
                                <input type="text" class="form-control" id="nameFunction" name="nameFunction">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="userRequest">Id пользователя</label>
                                <input type="text" class="form-control" id="userRequest" name="userRequest">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="dataEvent">Данные</label>
                                <input type="text" class="form-control" id="dataEvent" name="dataEvent">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary m-2" id="btnJournalEventFilter">Найти</button>
                    </form>
                </div>
                <table id="DTJournalEventView" class="display">
                    <thead>
                    <tr>
                        <th>Id события</th>
                        <th>Имя события</th>
                        <th>Имя функции</th>
                        <th>Id пользователя</th>
                        <th>Дата события</th>
                        <th>Данные</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header bg-info" id="headingFour"  data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
            <h5 class="mb-0">
                <button class="btn collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    Список ошибок
                </button>
            </h5>
        </div>
        <div id="collapseFour" class="collapse multi-collapse" aria-labelledby="headingFour" data-parent="#accordion">
            <div class="card-body">
                <div class="m-3" >
                    <form method="post" id = "formJournalErrorView">
                        <h2>Сортировка списка ошибок</h2>
                        <div class="form-row">
                            <div class="form-group col-md-1">
                                <label for="idError">Id ошибки</label>
                                <input type="text" class="form-control" id="idError" name="idError">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="nameError">Имя ошибки</label>
                                <input type="text" class="form-control" id="nameError" name="nameError">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="nameFunctionEr">Имя функции</label>
                                <input type="text" class="form-control" id="nameFunctionEr" name="nameFunctionEr">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="userRequestEr">Id пользователя</label>
                                <input type="text" class="form-control" id="userRequestEr" name="userRequestEr">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary m-2" id="btnJournalErrorFilter">Найти</button>
                    </form>
                </div>
                <table id="DTJournalErrorView" class="display">
                    <thead>
                    <tr>
                        <th>Id ошибки</th>
                        <th>Имя ошибки</th>
                        <th>Имя функции</th>
                        <th>Id пользователя</th>
                        <th>Дата ошибки</th>
                        <th>Описание</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" charset="utf8">
    <%@include file='./../js/multiSelectAdmin.js' %>
</script>
</html>
