package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;
import app.entityes.GroupFunctionEntity;
import app.entityes.JournalUserRequestEntity;
import app.entityes.UsersEntity;

import java.util.Collection;

public interface UserDAO extends DAOMain<UsersEntity> {

    public Collection<UsersEntity> getUsers(int limit, int offset, UsersEntity usersEntity);
    public UsersEntity getControllersByIdUser(int idUser);
    public UsersEntity getGroupFunctionsByIdUser(int idUser);
    public UsersEntity getJournalUserRequestsByIdUser(int idUser);
    public UsersEntity getUserRoleByRole(int idUser);
    public UsersEntity getUserStatusByStatus(int idUser);
    public UsersEntity getUserById(int idUser);
    public UsersEntity getUserAllChild(int idUser);
}
