package app.DAO.DAOinterfaces;

import app.entityes.*;

import java.util.Collection;

public interface UserDAO extends DAOMain<UsersEntity> {

    public Collection<UsersEntity> getUsers(int limit, int offset, UsersEntity usersEntity);
    public Collection<UserviewEntity> getUsersView(int limit, int offset, UserviewEntity userviewEntity);
    public Collection<JournalUserRequestViewEntity> getJournalUserRequestView(int limit, int offset, Long idUser);
    public Collection<UserStatusEntity> getUserStatus();
    public Long addRequest(JournalUserRequestEntity journalUserRequestEntity);
    public UsersEntity getControllersByIdUser(Long idUser);
    public UsersEntity getGroupFunctionsByIdUser(Long idUser);
    public UsersEntity getJournalUserRequestsByIdUser(Long idUser);
    public UsersEntity getUserRoleByRole(Long idUser);
    public UsersEntity getUserStatusByStatus(Long idUser);
    public UsersEntity getUserById(Long idUser);
    public UsersEntity authorization(String login);
    public UsersEntity getUserAllChild(Long idUser);
}
