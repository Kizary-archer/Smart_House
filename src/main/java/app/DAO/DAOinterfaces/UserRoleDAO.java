package app.DAO.DAOinterfaces;

import app.entityes.UserRoleEntity;
import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;

import java.util.Collection;

public interface UserRoleDAO extends DAOMain<UserRoleEntity> {

    public Collection<UserRoleEntity> getUserRole(int limit, int offset, UserRoleEntity userRoleEntity);
    public UserRoleEntity getPermissionUserRolesByIdRole(int idRole);
    public UserRoleEntity getUsersByIdRole(int idRole);
    public UserRoleEntity getUserById(int idRole);
}
