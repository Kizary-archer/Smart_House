package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;

import java.util.Collection;

public interface ControllersDAO extends DAOMain<ControllersEntity> {

    public Collection<ControllersEntity> getUsers(int limit, int offset, ControllersEntity controllersEntity);
    public ControllersEntity getControllerModelByModel(int idController);
    public ControllersEntity getWorkStatusByWorkStatus(int idController);
    public ControllersEntity getDevicesByIdController(int idController);
    public ControllersEntity getGroupsControllersByIdController(int idController);
    public ControllersEntity getControllerById(int idController);

}
