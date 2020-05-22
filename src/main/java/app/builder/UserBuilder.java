package app.builder;

import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;

import javax.servlet.http.HttpServletRequest;

public final class UserBuilder {
    UsersEntity usersEntity = new UsersEntity();

    public UserBuilder(HttpServletRequest request) {
        if ((request.getParameter("idUser") != null)&&(!request.getParameter("idUser").equals("")))
            usersEntity.setIdUser(Long.valueOf(request.getParameter("idUser")));
        if ((request.getParameter("login") != null)&&(!request.getParameter("login").equals("")))
                usersEntity.setLogin(request.getParameter("login"));
        if ((request.getParameter("password") != null)&&(!request.getParameter("password").equals("")))
            usersEntity.setPassword(request.getParameter("password"));
        if ((request.getParameter("role") != null)&&(!request.getParameter("role").equals("")))
            usersEntity.setRole(Long.valueOf(request.getParameter("role")));
        if ((request.getParameter("status") != null)&&(!request.getParameter("status").equals("")))
            usersEntity.setStatus(Long.valueOf(request.getParameter("status")));
    }
    public UsersEntity build() {
        return usersEntity;
    }
}
