package app.services;

import app.DAO.DAOinterfaces.UserDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;

import java.util.Collection;

public class UserService {

    public boolean addUser(UsersEntity usersEntity){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.add(usersEntity);
    }
    public boolean updUser(UsersEntity usersEntity){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.update(usersEntity);
    }
    public UsersEntity getUserById(int idUser){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.getUserById(idUser);
    }
    public boolean delUser(UsersEntity usersEntity){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.delete(usersEntity);
    }
    public Collection<UsersEntity> getUsers(int limit, int offset, UsersEntity usersEntity){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.getUsers(limit,offset,usersEntity);
    }
    public Collection<UserviewEntity> getUsersView(int limit, int offset, UserviewEntity userviewEntity){
        UserDAO userDAO = DAOCreateFactoryUtil.getInstance().getUserDAO();
        return  userDAO.getUsersView(limit,offset,userviewEntity);
    }
}
