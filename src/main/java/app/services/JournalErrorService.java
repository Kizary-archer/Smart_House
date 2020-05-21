package app.services;

import app.DAO.DAOinterfaces.JournalErrorDAO;
import app.DAO.DAOinterfaces.JournalEventDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.JournalErrorEntity;
import app.entityes.JournalErrorViewEntity;
import app.entityes.JournalEventEntity;

import java.util.Collection;

public class JournalErrorService {

    public Collection<JournalErrorEntity> getJournalErrors(int limit, int offset, JournalErrorEntity journalErrorEntity){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getJournalErrors(limit,offset,journalErrorEntity);
    }
    public Collection<JournalErrorViewEntity> getJournalErrorView(int limit, int offset, JournalErrorViewEntity journalErrorViewEntity){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getJournalErrorView(limit,offset,journalErrorViewEntity);
    }
    public boolean addJournalError(JournalErrorEntity journalErrorEntity){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.add(journalErrorEntity);
    }
    public boolean updJournalError(JournalErrorEntity journalErrorEntity){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.update(journalErrorEntity);
    }
    public boolean delJournalError(JournalErrorEntity journalErrorEntity){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.delete(journalErrorEntity);
    }
    public JournalErrorEntity getJournalErrorById(int idError){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getJournalErrorById(idError);
    }
    public JournalErrorEntity getTypeErrorByTypeError(int idError){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getTypeErrorByTypeError(idError);
    }
    public JournalErrorEntity getJournalUserRequestByUserRequest(int idError){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getJournalUserRequestByUserRequest(idError);
    }
    public JournalErrorEntity getFunctionDevicesByFunctionDevices(int idError){
        JournalErrorDAO journalErrorDAO = DAOCreateFactoryUtil.getInstance().getJournalErrorDAO();
        return  journalErrorDAO.getFunctionDevicesByFunctionDevices(idError);
    }
}
