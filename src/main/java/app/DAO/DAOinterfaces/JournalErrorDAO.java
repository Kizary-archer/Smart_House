package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;
import app.entityes.JournalErrorEntity;
import app.entityes.JournalErrorViewEntity;

import java.util.Collection;

public interface JournalErrorDAO extends DAOMain<JournalErrorEntity> {

    public Collection<JournalErrorEntity> getJournalErrors(int limit, int offset, JournalErrorEntity journalErrorEntity);
    public Collection<JournalErrorViewEntity> getJournalErrorView(int limit, int offset, JournalErrorViewEntity journalErrorViewEntity);
    public JournalErrorEntity getTypeErrorByTypeError(int idError);
    public JournalErrorEntity getJournalUserRequestByUserRequest(int idError);
    public JournalErrorEntity getFunctionDevicesByFunctionDevices(int idError);
    public JournalErrorEntity getJournalErrorById(int idError);
}
