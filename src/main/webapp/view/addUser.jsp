<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-50 p-3 mx-auto" >
        <h2>Добавить  пользователя</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="login">Логин</label>
                    <input type="text" class="form-control" id="login" name="login" placeholder="Логин">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                </div>
            </div>
                <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="role">Роль</label>
                    <select id="role" class="form-control" name="role" >
                        <option value="" selected>Выберите роль</option>
                        <c:forEach var="role" items="${roles}">
                                <option value="${role.idRole}">${role.nameRole}</option>
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
                            <option value="${status.idUserStatus}">${status.statusName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./addUser">Добавить</button>
        </form>
        <c:if test="${isUserAdded == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-8" role="alert">
                <strong>Пользователь добавлен</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isUserAdded == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-8" role="alert">
                <strong>Пользователь не добавлен</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>

</div>
</body>
</html>