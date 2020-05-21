package app.DAO.DAOinterfaces;

import app.entityes.DevicesEntity;
import app.entityes.JournalEventEntity;
import app.entityes.JournalEventViewEntity;

import java.util.Collection;

public interface JournalEventDAO extends DAOMain<JournalEventEntity> {

    public Collection<JournalEventEntity> getJournalEvents(int limit, int offset, JournalEventEntity journalEventEntity);
    public Collection<JournalEventViewEntity> getJournalViewEvents(int limit, int offset, JournalEventViewEntity journalEventViewEntity);
    public JournalEventEntity getTypeEventByTypeEvent(int idEvent);
    public JournalEventEntity getFunctionDevicesByFunctionDevices(int idEvent);
    public JournalEventEntity getJournalUserRequestByUserRequest(int idEvent);
    public JournalEventEntity getJournalEventById(int idEvent);
}
