package app.services;

import app.DAO.DAOinterfaces.UserDAO;
import app.DAO.DAOinterfaces.UserRoleDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.UserRoleEntity;
import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;

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
    public UserRoleEntity getUserById(int idRole){
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
    public UserRoleEntity getPermissionUserRolesByIdRole(int idRole){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getPermissionUserRolesByIdRole(idRole);
    }
    public UserRoleEntity getUsersByIdRole(int idRole){
        UserRoleDAO userRoleDAO = DAOCreateFactoryUtil.getInstance().getUserRoleDAO();
        return  userRoleDAO.getUsersByIdRole(idRole);
    }
}
