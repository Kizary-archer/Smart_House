package app.DAO.DAOinterfaces;

import app.entityes.ControllersEntity;
import app.entityes.JournalErrorEntity;
import app.entityes.JournalErrorViewEntity;

import java.util.Collection;

public interface JournalErrorDAO extends DAOMain<JournalErrorEntity> {

    public Collection<JournalErrorEntity> getJournalErrors(int limit, int offset, JournalErrorEntity journalErrorEntity);
    public Collection<JournalErrorViewEntity> getJournalErrorView(int limit, int offset, JournalErrorViewEntity journalErrorViewEntity);
    public JournalErrorEntity getTypeErrorByTypeError(Long idError);
    public JournalErrorEntity getJournalUserRequestByUserRequest(Long idError);
    public JournalErrorEntity getFunctionDevicesByFunctionDevices(Long idError);
    public JournalErrorEntity getJournalErrorById(Long idError);
}
