package app.services;

import app.DAO.DAOinterfaces.ControllersDAO;
import app.DAO.DAOinterfaces.DevicesDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.ControllersEntity;
import app.entityes.DevicesEntity;
import app.entityes.DeviceviewEntity;

import java.sql.Timestamp;
import java.util.Collection;

public class ControllerService {

    public boolean addController(ControllersEntity controllersEntity){
        ControllersDAO controllersDAO = DAOCreateFactoryUtil.getInstance().getControllersDAO();
        controllersEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  controllersDAO.add(controllersEntity);
    }
    public boolean updController(ControllersEntity controllersEntity){
        ControllersDAO controllersDAO = DAOCreateFactoryUtil.getInstance().getControllersDAO();
        controllersEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  controllersDAO.update(controllersEntity);
    }
    public boolean delController(ControllersEntity controllersEntity){
        ControllersDAO controllersDAO = DAOCreateFactoryUtil.getInstance().getControllersDAO();
        controllersEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  controllersDAO.delete(controllersEntity);
    }
    public ControllersEntity getControllerById(Long idController){
        ControllersDAO controllersDAO = DAOCreateFactoryUtil.getInstance().getControllersDAO();
        return  controllersDAO.getControllerById(idController);
    }
    public Collection<ControllersEntity> getControllers(int limit, int offset, ControllersEntity controllersEntity){
        ControllersDAO controllersDAO = DAOCreateFactoryUtil.getInstance().getControllersDAO();
        return  controllersDAO.getControllers(limit,offset, controllersEntity);
    }

}
