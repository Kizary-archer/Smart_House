<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/view/template/header.jsp"/>


<div class="mx-auto" style="width: 200px;">
    <button type="button" class="btn btn-primary btn-lg m-3" onclick="document.location = './admin'">Админка</button>
    <button type="button" class="btn btn-primary btn-lg  m-3" onclick="document.location = './addApartmentSale'">Добавить квартиру</button>
    <button type="button" class="btn btn-primary btn-lg  m-3" onclick="document.location = './addApartmentSale'">Продать квартиру</button>
</div>
</body>
</html>