package app.services;

import app.DAO.DAOinterfaces.UserRoleDAO;
import app.domain.UserRoleEntity;

import java.util.Collection;

public class UserRoleService {

    public boolean addUser(UserRoleEntity userRoleEntity){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.add(userRoleEntity);
    }
    public boolean updUser(UserRoleEntity userRoleEntity){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.update(userRoleEntity);
    }
    public UserRoleEntity getUserById(Long idRole){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getUserRoleById(idRole);
    }
    public boolean delUser(UserRoleEntity userRoleEntity){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.delete(userRoleEntity);
    }

    public Collection<UserRoleEntity> getUserRole(int limit, int offset, UserRoleEntity userRoleEntity){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getUserRole(limit,offset,userRoleEntity);
    }
    public UserRoleEntity getPermissionUserRolesByIdRole(Long idRole){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getPermissionUserRolesByIdRole(idRole);
    }
    public UserRoleEntity getUsersByIdRole(Long idRole){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getUsersByIdRole(idRole);
    }
}
