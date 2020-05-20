package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;
import app.entityes.JournalErrorEntity;

import java.util.Collection;

public interface JournalErrorDAO extends DAOMain<JournalErrorEntity> {

    public Collection<JournalErrorEntity> getJournalErrors(int limit, int offset, JournalErrorEntity journalErrorEntity);
    public JournalErrorEntity getTypeErrorByTypeError(int idError);
    public JournalErrorEntity getJournalUserRequestByUserRequest(int idError);
    public JournalErrorEntity getFunctionDevicesByFunctionDevices(int idError);
    public JournalErrorEntity getJournalErrorById(int idError);
}
