<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<div class="p-3">
    <h2>Найти дом</h2>
    <div class="w-50 p-3" >
        <form method="post" id = "formSearchHouse">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="idHouse">id Дома</label>
                    <input type="text" class="form-control" id="idHouse" name="idHouse" placeholder="id Дома">
                </div>
                <div class="form-group col-md-4">
                    <label for="numberHouse">Номер дома</label>
                    <input type="text" class="form-control" id="numberHouse" name="numberHouse" placeholder="Номер дома">
                </div>
                <div class="form-group col-md-4">
                    <label for="nameSeries">стр.серия</label>
                    <input type="text" class="form-control" id="nameSeries" name="nameSeries" placeholder="стр.серия">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="nameStreet">Название улицы</label>
                    <input type="text" class="form-control" id="nameStreet" name="nameStreet" placeholder="Название улицы">
                </div>
                <div class="form-group col-md-6">
                    <label for="nameDistrict">Название района</label>
                    <input type="text" class="form-control" id="nameDistrict" name="nameDistrict" placeholder="Название района">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="nameCity">Название города</label>
                    <input type="text" class="form-control" id="nameCity" name="nameCity" placeholder="Название города">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" formaction="./searchHouse">Найти</button>
        </form>
    </div>
</div>
<table id="tablehouses" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Номер дома</th>
        <th>стр.серия</th>
        <th>Название улицы</th>
        <th>Название района</th>
        <th>Название города</th>
    </tr>
    </thead>
</table>