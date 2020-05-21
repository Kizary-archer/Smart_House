package app.Util;

import app.DAO.DAOinterfaces.JournalErrorDAO;
import app.DAO.DAOinterfaces.JournalEventDAO;
import app.DAO.DAOinterfaces.UserDAO;
import app.DAO.DAOinterfaces.UserRoleDAO;
import app.DAO.JournalErrorDAOImpl;
import app.DAO.JournalEventDAOImpl;
import app.DAO.UserDAOImpl;
import app.DAO.UserRoleDAOImpl;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static UserDAO userDAO = null;
    private static UserRoleDAO userRoleDAO = null;
    private static JournalEventDAO journalEventDAO = null;
    private static JournalErrorDAO journalErrorDAO = null;


    public static DAOCreateFactoryUtil getInstance() {
        if (instance == null) {
            instance = new DAOCreateFactoryUtil();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
    public UserRoleDAO getUserRoleDAO() {
        if (userRoleDAO == null) {
            userRoleDAO = new UserRoleDAOImpl();
        }
        return userRoleDAO;
    }
    public JournalEventDAO getJournalEventDAO() {
        if (journalEventDAO == null) {
            journalEventDAO = new JournalEventDAOImpl();
        }
        return journalEventDAO;
    }
    public JournalErrorDAO getJournalErrorDAO() {
        if (journalErrorDAO == null) {
            journalErrorDAO = new JournalErrorDAOImpl();
        }
        return journalErrorDAO;
    }
}
