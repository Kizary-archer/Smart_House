<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/view/template/header.jsp"/>

<div>
    <c:if test="${isDocumentdel == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Документ удалён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isClientdel == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Клиент удалён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isAgentdel == true}">
        <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
            <strong>Агент удалён</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${isApartmentdel == true}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Квартира удалена</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${delApartmentSale == true}">
        <div class="alert alert-danger alert-dismissible fade show col-md-4" role="alert">
            <strong>Запись о продаже удалена</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
</div>
<div class="mx-auto" style="width: 200px;">
    <button type="button" class="btn btn-primary btn-lg m-3" onclick="document.location = './addClient'">Добавить клиента</button>
    <button type="button" class="btn btn-primary btn-lg  m-3" onclick="document.location = './addApartmentSale'">Добавить квартиру</button>
    <button type="button" class="btn btn-primary btn-lg  m-3" onclick="document.location = './addApartmentSale'">Продать квартиру</button>
</div>
</body>
</html>