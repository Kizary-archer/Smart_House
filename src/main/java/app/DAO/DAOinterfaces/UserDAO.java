package app.DAO.DAOinterfaces;

import app.entityes.ClientEntity;

import java.util.Collection;

public interface ClientDAO extends DAOMain<ClientEntity> {

    public Collection<ClientEntity> getClients(int limit, int offset, ClientEntity clientEntity);
    public ClientEntity getClientDocument(int idClient);
    public ClientEntity getClientapartmentSales(int idClient);
    public ClientEntity getClientapartments(int idClient);
    public ClientEntity getClientById(int idClient);
    public ClientEntity getClientAllChild(int idClient);
}
