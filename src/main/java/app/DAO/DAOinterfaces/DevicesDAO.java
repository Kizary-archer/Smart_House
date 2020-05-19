package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.UsersEntity;

import java.util.Collection;

public interface DevicesDAO extends DAOMain<DevicesEntity> {

    public Collection<DevicesEntity> getDevices(int limit, int offset, DevicesEntity devicesEntity);
    public DevicesEntity getControllersByController(int idDevice);
    public DevicesEntity getTypeDevicesByTypeDevice(int idDevice);
    public DevicesEntity getWorkStatusByWorkStatus(int idDevice);
    public DevicesEntity getFunctionDevicesByIdDevice(int idDevice);
    public DevicesEntity getDeviceById(int idDevice);


}
