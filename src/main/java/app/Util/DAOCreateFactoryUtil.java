package app.Util;

import app.DAO.*;
import app.DAO.DAOinterfaces.*;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static CityDAO cityDAO = null;
    private static ClientDAO clientDAO = null;
    private static DocumentDAO documentDAO = null;
    private static ApartmentDAO apartmentDAO = null;
    private static AgentDAO agentDAO = null;
    private static ApartmentSaleDAO apartmentSaleDAO = null;

    public static DAOCreateFactoryUtil getInstance() {
        if (instance == null) {
            instance = new DAOCreateFactoryUtil();
        }
        return instance;
    }

    public CityDAO getCityDAO() {
        if (cityDAO == null) {
            cityDAO = new CityDAOImpl();
        }
        return cityDAO;
    }

    public ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    public DocumentDAO getDocumentDAO() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAOImpl();
        }
        return documentDAO;
    }
    public ApartmentDAO getApartmentDAO() {
        if (apartmentDAO == null) {
            apartmentDAO = new ApartmentDAOImpl() {
            };
        }
        return apartmentDAO;
    }
    public AgentDAO getAgentDAO() {
        if (agentDAO == null) {
            agentDAO = new AgentDAOImpl() {
            };
        }
        return agentDAO;
    }
    public ApartmentSaleDAO getApartmentSaleDAO() {
        if (apartmentSaleDAO == null) {
            apartmentSaleDAO = new ApartmentSaleDAOImpl() {
            };
        }
        return apartmentSaleDAO;
    }
}
