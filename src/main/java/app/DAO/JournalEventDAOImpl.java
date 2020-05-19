package app.DAO;

import app.DAO.DAOinterfaces.DevicesDAO;
import app.DAO.DAOinterfaces.JournalEventDAO;
import app.entityes.DevicesEntity;
import app.entityes.JournalEventEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JournalEventDAOImpl implements JournalEventDAO {

    @Override
    public Collection<JournalEventEntity> getJournalEvents (int limit, int offset, JournalEventEntity journalEventEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<JournalEventEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(JournalEventEntity.class);
            Root<JournalEventEntity> root = criteriaBuilderQuery.from(JournalEventEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(journalEventEntity.getIdEvent() != null){
                p.add(criteriaBuilder.equal(root.get("idEvent"),journalEventEntity.getIdEvent()));
            }
            if(journalEventEntity.getTypeEvent() != null){
                p.add(criteriaBuilder.equal(root.get("typeEvent"),journalEventEntity.getTypeEvent()));
            }
            if(journalEventEntity.getFunctionDevices() != null){
                p.add(criteriaBuilder.equal(root.get("functionDevices"),journalEventEntity.getFunctionDevices()));
            }
            if(journalEventEntity.getData() != null){
                p.add(criteriaBuilder.equal(root.get("data"),journalEventEntity.getData()));
            }
            if(journalEventEntity.getDateEvent() != null){
                p.add(criteriaBuilder.equal(root.get("dateEvent"),journalEventEntity.getDateEvent()));
            }
            if(journalEventEntity.getUserRequest() != null){
                p.add(criteriaBuilder.equal(root.get("userRequest"),journalEventEntity.getUserRequest()));
            }
            if(!p.isEmpty()) {
                Predicate[] pr = new Predicate[p.size()];
                p.toArray(pr);
                criteriaBuilderQuery.where((pr));
            }
            Query query = session.createQuery(criteriaBuilderQuery);
            if(limit != 0) query.setMaxResults(limit);
            query.setFirstResult(offset);
            List res = query.getResultList();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public JournalEventEntity getTypeEventByTypeEvent(int idEvent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from JournalEventEntity f " +
                    "left join fetch f.typeEventByTypeEvent " +
                    "where f.idEvent = :idEvent";
            Query query =  session.createQuery(hql);
            query.setParameter("idEvent",idEvent);
            JournalEventEntity res = (JournalEventEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public JournalEventEntity getFunctionDevicesByFunctionDevices(int idEvent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from JournalEventEntity f " +
                    "left join fetch f.functionDevicesByFunctionDevices " +
                    "where f.idEvent = :idEvent";
            Query query =  session.createQuery(hql);
            query.setParameter("idEvent",idEvent);
            JournalEventEntity res = (JournalEventEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public JournalEventEntity getJournalUserRequestByUserRequest(int idEvent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from JournalEventEntity f " +
                    "left join fetch f.journalUserRequestByUserRequest " +
                    "where f.idEvent = :idEvent";
            Query query =  session.createQuery(hql);
            query.setParameter("idEvent",idEvent);
            JournalEventEntity res = (JournalEventEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public JournalEventEntity getJournalEventById(int idEvent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from JournalEventEntity where idEvent = :idEvent";
            Query query =  session.createQuery(hql);
            query.setParameter("idEvent",idEvent);
            JournalEventEntity res = (JournalEventEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
