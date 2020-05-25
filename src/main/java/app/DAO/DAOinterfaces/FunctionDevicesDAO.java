package app.DAO.DAOinterfaces;

import app.entityes.*;

import java.util.Collection;

public interface FunctionDevicesDAO extends DAOMain<FunctionDevicesEntity> {

    public Collection<FunctionDevicesEntity> getFunctionDevices(int limit, int offset, FunctionDevicesEntity functionDevicesEntity);
    public Collection<TypeFunctionEntity> getTypeFunctions();
    FunctionDevicesEntity getDevicesByDevice(Long idFunction);
    public FunctionDevicesEntity getTypeFunctionByTypeFunction(Long idFunction);
    public FunctionDevicesEntity getFunctionsGroupsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getJournalErrorsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getJournalEventsByIdFunction(Long idFunction);
    public FunctionDevicesEntity getFunctionById(Long idFunction);
}
