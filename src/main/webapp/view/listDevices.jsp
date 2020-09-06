<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="m-3">
<div class="w-25">
    <form method="post" id = "formDevicesView">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="idDevice">Id</label>
                <input type="text" class="form-control" id="idDevice" name="idDevice">
            </div>
            <div class="form-group col-md-8">
                <label for="nameDevice">имя устройства</label>
                <input type="text" class="form-control" id="nameDevice" name="nameDevice">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nameController">Контроллер</label>
                <input type="text" class="form-control" id="nameController" name="nameController">
            </div>
            <div class="form-group col-md-6">
                <label for="nameType">Тип</label>
                <input type="text" class="form-control" id="nameType" name="nameType">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="nameStatus">Статус</label>
                <input type="text" class="form-control" id="nameStatus" name="nameStatus">
            </div>
        </div>
        <button type="submit" class="btn btn-primary m-2" id="btnDeviceViewFilter">Найти</button>
    </form>
</div>
<table id="DTDeviceView" class="display">
    <thead>
    <tr>
        <th>Id устройства</th>
        <th>Устройство</th>
        <th>Контроллер</th>
        <th>Тип</th>
        <th>Статус</th>
    </tr>
    </thead>
</table>
</div>
</body>
<script type="text/javascript" charset="utf8" src="./../js/listDevice.js"></script>
</html>
