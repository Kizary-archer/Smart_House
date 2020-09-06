package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;

import java.util.Collection;

public interface ControllersDAO extends DAOMain<ControllersEntity> {

    public Collection<ControllersEntity> getControllers(int limit, int offset, ControllersEntity controllersEntity);
    public ControllersEntity getControllerModelByModel(Long idController);
    public ControllersEntity getWorkStatusByWorkStatus(Long idController);
    public ControllersEntity getDevicesByIdController(Long idController);
    public ControllersEntity getGroupsControllersByIdController(Long idController);
    public ControllersEntity getControllerById(Long idController);

}
