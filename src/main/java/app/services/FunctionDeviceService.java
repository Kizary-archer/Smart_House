package app.services;

import app.DAO.DAOinterfaces.FunctionDevicesDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.*;
import com.google.gson.JsonArray;

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
    public FunctionDevicesEntity getJournalEventsByIdFunction(Long idFunction){
        FunctionDevicesDAO functionDevicesDAO = DAOCreateFactoryUtil.getInstance().getFunctionDevicesDAO();
        return  functionDevicesDAO.getJournalEventsByIdFunction(idFunction);
    }
    public String getFunctionDataJson(Long idFunction){
        JsonArray jsonList= new JsonArray();
        JsonArray jsonEntity= new JsonArray();
        FunctionDevicesEntity functionDevicesEntity = getJournalEventsByIdFunction(idFunction);
        Collection<JournalEventEntity> journalEventEntities = functionDevicesEntity.getJournalEventsByIdFunction();
        for (JournalEventEntity journalEventEntity:journalEventEntities){
            JsonArray jsonElement = new JsonArray();
            jsonElement.add(journalEventEntity.getDateEvent().toInstant().plusMillis(10800000).toEpochMilli());
            jsonElement.add(journalEventEntity.getData());
            jsonEntity.add(jsonElement);
        }
        return jsonEntity.toString();
    }
}
