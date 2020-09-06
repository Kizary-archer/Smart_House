package app.builder;

import app.entityes.UserRoleEntity;
import app.entityes.UserviewEntity;

import javax.servlet.http.HttpServletRequest;

public final class UserRoleBuilder {
    UserRoleEntity userRoleEntity = new UserRoleEntity();

    public UserRoleBuilder(HttpServletRequest request) {
        if ((request.getParameter("idRole") != null)&&(!request.getParameter("idRole").equals("")))
                userRoleEntity.setIdRole(Long.valueOf(request.getParameter("idRole")));
        if ((request.getParameter("nameRole") != null)&&(!request.getParameter("nameRole").equals("")))
                userRoleEntity.setNameRole(request.getParameter("nameRole"));
        if ((request.getParameter("description") != null)&&(!request.getParameter("description").equals("")))
            userRoleEntity.setDescription(request.getParameter("description"));
    }
    public UserRoleEntity build() {
        return userRoleEntity;
    }
}
