<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="w-25 p-3 mx-auto" >
        <h2>Добавить  устройство</h2>
        <form method="post" class="py-3" >
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="nameDevice">Название устройства</label>
                    <input type="text" class="form-control" id="nameDevice" name="nameDevice" placeholder="Название устройства">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="controller">Контроллер</label>
                    <select id="controller" class="form-control" name="controller" >
                        <option value="" selected>Выберите контроллер</option>
                        <c:forEach var="controller" items="${controllers}">
                            <option value="${controller.idController}">${controller.nameController}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="typeDevice">Тип устройства</label>
                    <select id="typeDevice" class="form-control" name="typeDevice" >
                        <option value="" selected>Выберите тип</option>
                        <c:forEach var="type" items="${types}">
                            <option value="${type.idType}">${type.nameType}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="workStatus">Статус</label>
                    <select id="workStatus" class="form-control" name="workStatus" >
                        <option value="" selected>Выберите статус</option>
                        <c:forEach var="status" items="${statuses}">
                            <option value="${status.idStatus}">${status.nameStatus}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description">Описание</label>
                    <textarea id="description" name="description" placeholder="Описание"cols="30" rows="3"></textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./addDevice">Добавить</button>
        </form>
        <c:if test="${isDeviceAdded == true}">
            <div class="alert alert-success alert-dismissible fade show col-md-12" role="alert">
                <strong>Устройство добавлено</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${isDeviceAdded == false}">
            <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
                <strong>Устройство не добавлено</strong> Проверьте вводимые значения
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>

</div>
</body>
</html>