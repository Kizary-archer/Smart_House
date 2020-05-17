package app.services;

import app.DAO.DAOinterfaces.ClientDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.*;

import java.util.Collection;

public class ClientService {

    public boolean addClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.add(clientEntity);
    }
    public boolean delClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.delete(clientEntity);
    }
    public boolean updClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.update(clientEntity);
    }
    public ClientEntity getClientById(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientById(idClient);
    }
    public Collection<ClientEntity> getClients(int limit,int offset,ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClients(limit,offset,clientEntity);
    }

    public Collection<DocumentsClientEntity> getClientDocuments(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientDocument(idClient).getDocumentsClientsByIdClient();
    }
    public Collection<ApartmentSaleEntity> getClientapartmentSales(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientapartmentSales(idClient).getApartmentSalesByIdClient();
    }
    public Collection<ApartmentEntity> getClientapartments(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientapartments(idClient).getApartmentsByIdClient();
    }
    public ClientEntity getClientAllData(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return clientDAO.getClientAllChild(idClient);
    }
}
