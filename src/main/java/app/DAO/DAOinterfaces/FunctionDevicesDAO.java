package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.FunctionDevicesEntity;

import java.util.Collection;

public interface FunctionDevicesDAO extends DAOMain<FunctionDevicesEntity> {

    public Collection<FunctionDevicesEntity> getDevices(int limit, int offset, FunctionDevicesEntity functionDevicesEntity);
    public FunctionDevicesEntity getDevicesByDevice(Long idFunction);
    public FunctionDevicesEntity getTypeFunctionByTypeFunction(Long idFunction);
    public FunctionDevicesEntity getFunctionsGroupsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getJournalErrorsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getJournalEventsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getFunctionById(Long idFunction);


}
