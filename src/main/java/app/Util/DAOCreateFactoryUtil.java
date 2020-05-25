package app.Util;

import app.DAO.*;
import app.DAO.DAOinterfaces.*;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static UserDAO userDAO = null;
    private static UserRoleDAO userRoleDAO = null;
    private static JournalEventDAO journalEventDAO = null;
    private static JournalErrorDAO journalErrorDAO = null;
    private static DevicesDAO devicesDAO = null;
    private static ControllersDAO controllersDAO = null;
    private static FunctionDevicesDAO functionDevicesDAO = null;

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
    public DevicesDAO getDevicesDAO() {
        if (devicesDAO == null) {
            devicesDAO = new DevicesDAOImpl();
        }
        return devicesDAO;
    }
    public ControllersDAO getControllersDAO() {
        if (controllersDAO == null) {
            controllersDAO = new ControllersDAOImpl();
        }
        return controllersDAO;
    }
    public FunctionDevicesDAO getFunctionDevicesDAO() {
        if (functionDevicesDAO == null) {
            functionDevicesDAO = new FunctionDeviceDAOImpl();
        }
        return functionDevicesDAO;
    }
}
