package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.JournalEventEntity;

import java.util.Collection;

public interface JournalEventDAO extends DAOMain<JournalEventEntity> {

    public Collection<JournalEventEntity> getJournalEvents(int limit, int offset, JournalEventEntity journalEventEntity);
    public JournalEventEntity getTypeEventByTypeEvent(int idEvent);
    public JournalEventEntity getFunctionDevicesByFunctionDevices(int idEvent);
    public JournalEventEntity getJournalUserRequestByUserRequest(int idEvent);
    public JournalEventEntity getJournalEventById(int idEvent);
}
