package app.services;

import app.DAO.DAOinterfaces.FunctionDevicesDAO;
import app.DAO.DAOinterfaces.UserDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.*;

import java.sql.Timestamp;
import java.util.Collection;

public class FunctionDeviceService {

    public boolean addFunctionDevice(FunctionDevicesEntity functionDevicesEntity){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        if((functionDevicesEntity.getData()<functionDevicesEntity.getMinData()) || (functionDevicesEntity.getData()>functionDevicesEntity.getMaxData()))
            return false;//проверка данных на принадлежность диапозону
        return  functionDevicesDAO.add(functionDevicesEntity);
    }
    public boolean updFunctionDevice(FunctionDevicesEntity functionDevicesEntity){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        if((functionDevicesEntity.getData()<functionDevicesEntity.getMinData()) || (functionDevicesEntity.getData()>functionDevicesEntity.getMaxData()))
            return false;//проверка данных на принадлежность диапозону 
        return  functionDevicesDAO.update(functionDevicesEntity);
    }
    public boolean delFunctionDevice(FunctionDevicesEntity functionDevicesEntity){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        return  functionDevicesDAO.delete(functionDevicesEntity);
    }
    public FunctionDevicesEntity getFunctionDeviceById(Long idFunction){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        return  functionDevicesDAO.getFunctionById(idFunction);
    }
    public Collection<TypeFunctionEntity> getTypeFunctions(){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        return  functionDevicesDAO.getTypeFunctions();
    }
}
