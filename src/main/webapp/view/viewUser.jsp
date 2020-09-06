<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-25 p-3 mx-auto" >
        <h2>  Пользователь</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="idUser">ID</label>
                    <input readonly type="text" class="form-control" id="idUser" name="idUser" value=${user.idUser}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="login">Логин</label>
                    <input type="text" class="form-control" id="login" name="login" value=${user.login}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" value=${user.password}>
                </div>
            </div>
                <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="role">Роль</label>
                    <select id="role" class="form-control" name="role" >
                        <c:forEach var="role" items="${roles}">
                                <option <c:if test="${user.role == role.idRole}">selected</c:if> value="${role.idRole}">${role.nameRole}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="role">Статус</label>
                    <select id="status" class="form-control" name="status" >
                        <c:forEach var="status" items="${statuses}">
                            <option <c:if test="${user.status == status.idUserStatus}">selected</c:if> value="${status.idUserStatus}">${status.statusName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./updUser">Обновить</button>
            <button type="submit" class="btn btn-danger m-1" formaction="./delUser">Удалить</button>
            <button type="reset" class="btn btn-warning">Отменить</button>
        </form>
        <c:if test="${isUserupd == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-12" role="alert">
                <strong>Данные пользователя обновлены</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isUserupd == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Данные пользователя не обновлены</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isUserdel == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Пользователь не удалён</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>
    <div class="accordion mx-auto " id="accordion" style="width: 90%;">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button id="btnUserList" class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Список запросов пользователя
                    </button>
                </h5>
            </div>
            <div id="collapseOne" class="collapse multi-collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <table id="DTUserRequestView" class="display">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>Логин</th>
                            <th>Имя события</th>
                            <th>Дата запроса</th>
                            <th>Статус</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
</div>
    <script type="text/javascript" charset="utf8" src="./../js/userTables.js"></script>
</body>
</html>