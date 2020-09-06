package app.DAO.DAOinterfaces;

import app.entityes.UserRoleEntity;
import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;

import java.util.Collection;

public interface UserRoleDAO extends DAOMain<UserRoleEntity> {

    public Collection<UserRoleEntity> getUserRole(int limit, int offset, UserRoleEntity userRoleEntity);
    public UserRoleEntity getPermissionUserRolesByIdRole(Long idRole);
    public UserRoleEntity getUsersByIdRole(Long idRole);
    public UserRoleEntity getUserRoleById(Long idRole);
}
