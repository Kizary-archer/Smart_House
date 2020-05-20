package app.Util;

import app.DAO.DAOinterfaces.UserDAO;
import app.DAO.UserDAOImpl;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static UserDAO userDAO = null;


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
}
