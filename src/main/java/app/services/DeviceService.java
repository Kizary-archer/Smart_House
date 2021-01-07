package app.services;

import app.DAO.DAOinterfaces.DevicesDAO;
import app.domain.*;

import java.sql.Timestamp;
import java.util.Collection;

public class DeviceService {
    public boolean addDevice(DevicesEntity devicesEntity){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        devicesEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  devicesDAO.add(devicesEntity);
    }
    public boolean updDevice(DevicesEntity devicesEntity){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        devicesEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  devicesDAO.update(devicesEntity);
    }
    public boolean delDevice(DevicesEntity devicesEntity){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        devicesEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
        return  devicesDAO.delete(devicesEntity);
    }
    public DevicesEntity getDeviceById(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getDeviceById(idDevice);
    }
    public Collection<DevicesEntity> getDevices(int limit, int offset, DevicesEntity devicesEntity){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getDevices(limit,offset, devicesEntity);
    }
    public Collection<FunctiondeviceviewEntity> getFunctionDeviceView(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getFunctionDeviceView(idDevice);
    }
    public Collection<DeviceviewEntity> getDevicesView(int limit, int offset, DeviceviewEntity deviceviewEntity){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getDevicesView(limit,offset, deviceviewEntity);
    }
    public Collection<TypeDevicesEntity> getDeviceType(){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getDeviceType();
    }
    public Collection<WorkStatusEntity> getDeviceWorkStatus(){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getDeviceWorkStatus();
    }
    public DevicesEntity getControllersByController(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getControllersByController(idDevice);
    }
    public DevicesEntity getTypeDevicesByTypeDevice(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getTypeDevicesByTypeDevice(idDevice);
    }
    public DevicesEntity getWorkStatusByWorkStatus(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getWorkStatusByWorkStatus(idDevice);
    }
    public DevicesEntity getFunctionDevicesByIdDevice(Long idDevice){
        DevicesDAO devicesDAO = DAOCreateFactoryUtil.getInstance().getDevicesDAO();
        return  devicesDAO.getFunctionDevicesByIdDevice(idDevice);
    }
}
