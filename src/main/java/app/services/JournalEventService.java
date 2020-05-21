package app.services;

import app.DAO.DAOinterfaces.JournalErrorDAO;
import app.DAO.DAOinterfaces.JournalEventDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.JournalErrorEntity;
import app.entityes.JournalEventEntity;
import app.entityes.JournalEventViewEntity;

import java.util.Collection;

public class JournalEventService {

    public Collection<JournalEventEntity> getJournalEvents(int limit, int offset, JournalEventEntity journalEventEntity){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getJournalEvents(limit,offset,journalEventEntity);
    }
    public Collection<JournalEventViewEntity> getJournalViewEvents(int limit, int offset, JournalEventViewEntity journalEventViewEntity){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getJournalViewEvents(limit,offset,journalEventViewEntity);
    }
    public boolean addJournalEvent(JournalEventEntity journalEventEntity){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.add(journalEventEntity);
    }
    public boolean updJournalEvent(JournalEventEntity journalEventEntity){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.update(journalEventEntity);
    }
    public JournalEventEntity getJournalEventById(int idEvent){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getJournalEventById(idEvent);
    }
    public boolean delJournalEvent(JournalEventEntity journalEventEntity){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.delete(journalEventEntity);
    }
    public JournalEventEntity getTypeEventByTypeEvent(int idEvent){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getTypeEventByTypeEvent(idEvent);
    }
    public JournalEventEntity getFunctionDevicesByFunctionDevices(int idEvent){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getFunctionDevicesByFunctionDevices(idEvent);
    }
    public JournalEventEntity getJournalUserRequestByUserRequest(int idEvent){
        JournalEventDAO journalEventDAO = DAOCreateFactoryUtil.getInstance().getJournalEventDAO();
        return  journalEventDAO.getJournalUserRequestByUserRequest(idEvent);
    }

}