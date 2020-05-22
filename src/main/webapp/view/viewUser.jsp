<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 p-3 mx-auto" >
        <h2>  Пользователь</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="login">Логин</label>
                    <input type="text" class="form-control" id="login" name="login" value=${user.login}>
                </div>
                <div class="form-group col-md-2">
                    <label for="idUser">ID</label>
                    <input readonly type="idUser" class="form-control" id="idUser" name="idUser" value=${user.idUser}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" value=${user.password}>
                </div>
            </div>
                <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="role">Роль</label>
                    <select id="role" class="form-control" name="role" >
                        <option value="" selected>Выберите роль</option>
                        <c:forEach var="role" items="${roles}">
                                <option <c:if test="${user.role == role.idRole}">selected</c:if> value="${role.idRole}">${role.nameRole}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="role">Статус</label>
                    <select id="status" class="form-control" name="status" >
                        <option value="" selected>Выберите статус</option>
                        <c:forEach var="status" items="${statuses}">
                            <option <c:if test="${user.status == status.idUserStatus}">selected</c:if> value="${status.idUserStatus}">${status.statusName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary m-2" formaction="./updUser">Обновить</button>
            <button type="submit" class="btn btn-danger m-2" formaction="./delUser">Удалить</button>
            <button type="reset" class="btn btn-warning m-2">Отменить</button>
        </form>
        <c:if test="${isUserupd == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-8" role="alert">
                <strong>Данные пользователя обновлены</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isUserupd == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-8" role="alert">
                <strong>Данные пользователя не обновлены</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isUserdel == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-8" role="alert">
                <strong>Пользователь не удалён</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>

</div>
</body>
</html>