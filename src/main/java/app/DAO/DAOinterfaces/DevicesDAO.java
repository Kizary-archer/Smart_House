package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.UsersEntity;

import java.util.Collection;

public interface DevicesDAO extends DAOMain<DevicesEntity> {

    public Collection<DevicesEntity> getDevices(int limit, int offset, DevicesEntity devicesEntity);
    public DevicesEntity getControllersByController(Long idDevice);
    public DevicesEntity getTypeDevicesByTypeDevice(Long idDevice);
    public DevicesEntity getWorkStatusByWorkStatus(Long idDevice);
    public DevicesEntity getFunctionDevicesByIdDevice(Long idDevice);
    public DevicesEntity getDeviceById(Long idDevice);


}
