package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.FunctionDevicesEntity;

import java.util.Collection;

public interface FunctionDevicesDAO extends DAOMain<FunctionDevicesEntity> {

    public Collection<FunctionDevicesEntity> getDevices(int limit, int offset, FunctionDevicesEntity functionDevicesEntity);
    public FunctionDevicesEntity getDevicesByDevice(int idFunction);
    public FunctionDevicesEntity getTypeFunctionByTypeFunction(int idFunction);
    public FunctionDevicesEntity getFunctionsGroupsByIdFunction(int idFunction);
    public FunctionDevicesEntity getJournalErrorsByIdFunction(int idFunction);
    public FunctionDevicesEntity getJournalEventsByIdFunction(int idFunction);
    public FunctionDevicesEntity getFunctionById(int idFunction);


}
