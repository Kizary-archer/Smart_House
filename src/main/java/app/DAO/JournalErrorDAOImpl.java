package app.DAO;

import app.DAO.DAOinterfaces.ControllersDAO;
import app.DAO.DAOinterfaces.JournalErrorDAO;
import app.entityes.ControllersEntity;
import app.entityes.JournalErrorEntity;
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

public class JournalErrorDAOImpl implements JournalErrorDAO {
    
    @Override
    public Collection<JournalErrorEntity> getJournalErrors(int limit, int offset, JournalErrorEntity journalErrorEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<JournalErrorEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(JournalErrorEntity.class);
            Root<JournalErrorEntity> root = criteriaBuilderQuery.from(JournalErrorEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(journalErrorEntity.getIdError() != null){
                p.add(criteriaBuilder.equal(root.get("idError"),journalErrorEntity.getIdError()));
            }
            if(journalErrorEntity.getTypeError() != null){
                p.add(criteriaBuilder.equal(root.get("typeError"),journalErrorEntity.getTypeError()));
            }
            if(journalErrorEntity.getUserRequest() != null){
                p.add(criteriaBuilder.equal(root.get("userRequest"),journalErrorEntity.getUserRequest()));
            }
            if(journalErrorEntity.getFunctionDevices() != null){
                p.add(criteriaBuilder.equal(root.get("functionDevices"),journalErrorEntity.getFunctionDevices()));
            }
            if(journalErrorEntity.getDateError() != null){
                p.add(criteriaBuilder.equal(root.get("dateError"),journalErrorEntity.getDateError()));
            }
            if(journalErrorEntity.getDescription() != null){
                p.add(criteriaBuilder.like(root.get("description"),journalErrorEntity.getDescription()));
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
    public JournalErrorEntity getTypeErrorByTypeError(int idError) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  j " +
                    "from JournalErrorEntity j " +
                    "left join fetch j.typeErrorByTypeError " +
                    "where j.idError = :idError";
            Query query =  session.createQuery(hql);
            query.setParameter("idError",idError);
            JournalErrorEntity res = (JournalErrorEntity) query.getSingleResult();
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
    public JournalErrorEntity getJournalUserRequestByUserRequest(int idError) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  j " +
                    "from JournalErrorEntity j " +
                    "left join fetch j.journalUserRequestByUserRequest " +
                    "where j.idError = :idError";
            Query query =  session.createQuery(hql);
            query.setParameter("idError",idError);
            JournalErrorEntity res = (JournalErrorEntity) query.getSingleResult();
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
    public JournalErrorEntity getFunctionDevicesByFunctionDevices(int idError) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  j " +
                    "from JournalErrorEntity j " +
                    "left join fetch j.functionDevicesByFunctionDevices " +
                    "where j.idError = :idError";
            Query query =  session.createQuery(hql);
            query.setParameter("idError",idError);
            JournalErrorEntity res = (JournalErrorEntity) query.getSingleResult();
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
    public JournalErrorEntity getJournalErrorById(int idError) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from JournalErrorEntity where idError = :idError";
            Query query =  session.createQuery(hql);
            query.setParameter("idError",idError);
            JournalErrorEntity res = (JournalErrorEntity) query.getSingleResult();
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
