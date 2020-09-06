package app.builder;

import app.entityes.UserviewEntity;

import javax.servlet.http.HttpServletRequest;

public final class UserViewBuilder {
    UserviewEntity userviewEntity = new UserviewEntity();

    public UserViewBuilder(HttpServletRequest request) {
        if ((request.getParameter("idUser") != null)&&(!request.getParameter("idUser").equals("")))
                userviewEntity.setIdUser(Long.valueOf(request.getParameter("idUser")));
        if ((request.getParameter("login") != null)&&(!request.getParameter("login").equals("")))
                userviewEntity.setLogin(request.getParameter("login"));
        if ((request.getParameter("statusName") != null)&&(!request.getParameter("statusName").equals("")))
            userviewEntity.setStatusName(request.getParameter("statusName"));
        if ((request.getParameter("nameRole") != null)&&(!request.getParameter("nameRole").equals("")))
            userviewEntity.setNameRole(request.getParameter("nameRole"));
    }
    public UserviewEntity build() {
        return userviewEntity;
    }
}
