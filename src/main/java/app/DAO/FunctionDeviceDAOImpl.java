package app.DAO;

import app.DAO.DAOinterfaces.ControllersDAO;
import app.DAO.DAOinterfaces.FunctionDevicesDAO;
import app.entityes.*;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FunctionDeviceDAOImpl implements FunctionDevicesDAO {

    @Override
    public Collection<FunctionDevicesEntity> getFunctionDevices(int limit, int offset, FunctionDevicesEntity functionDevicesEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<FunctionDevicesEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(FunctionDevicesEntity.class);
            Root<FunctionDevicesEntity> root = criteriaBuilderQuery.from(FunctionDevicesEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(functionDevicesEntity.getIdFunction() != null){
                p.add(criteriaBuilder.equal(root.get("idFunction"),functionDevicesEntity.getIdFunction()));
            }
            if(functionDevicesEntity.getDevice() != null){
                p.add(criteriaBuilder.equal(root.get("device"),functionDevicesEntity.getDevice()));
            }
            if(functionDevicesEntity.getTypeFunction() != null){
                p.add(criteriaBuilder.equal(root.get("typeFunction"),functionDevicesEntity.getTypeFunction()));
            }
            if(functionDevicesEntity.getNameFunction() != null){
                p.add(criteriaBuilder.like(root.get("nameFunction"),functionDevicesEntity.getNameFunction()));
            }
            if(functionDevicesEntity.getDescription() != null){
                p.add(criteriaBuilder.like(root.get("description"),functionDevicesEntity.getDescription()));
            }
            if(functionDevicesEntity.getData() != null){
                p.add(criteriaBuilder.equal(root.get("data"),functionDevicesEntity.getData()));
            }
            if(functionDevicesEntity.getMinData() != null){
                p.add(criteriaBuilder.equal(root.get("minData"),functionDevicesEntity.getMinData()));
            }
            if(functionDevicesEntity.getMaxData() != null){
                p.add(criteriaBuilder.equal(root.get("maxData"),functionDevicesEntity.getMaxData()));
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
    public Collection<TypeFunctionEntity> getTypeFunctions() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from TypeFunctionEntity ";
            Query query =  session.createQuery(hql);
            Collection<TypeFunctionEntity> res = query.getResultList();
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
    public FunctionDevicesEntity getDevicesByDevice(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from FunctionDevicesEntity f " +
                    "left join fetch f.devicesByDevice " +
                    "where f.idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
    public FunctionDevicesEntity getTypeFunctionByTypeFunction(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from FunctionDevicesEntity f " +
                    "left join fetch f.typeFunctionByTypeFunction " +
                    "where f.idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
    public FunctionDevicesEntity getFunctionsGroupsByIdFunction(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from FunctionDevicesEntity f " +
                    "left join fetch f.functionsGroupsByIdFunction " +
                    "where f.idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
    public FunctionDevicesEntity getJournalErrorsByIdFunction(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from FunctionDevicesEntity f " +
                    "left join fetch f.journalErrorsByIdFunction " +
                    "where f.idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
    public FunctionDevicesEntity getJournalEventsByIdFunction(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  f " +
                    "from FunctionDevicesEntity f " +
                    "left join fetch f.journalEventsByIdFunction " +
                    "where f.idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
    public FunctionDevicesEntity getFunctionById(Long idFunction) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from FunctionDevicesEntity where idFunction = :idFunction";
            Query query =  session.createQuery(hql);
            query.setParameter("idFunction",idFunction);
            FunctionDevicesEntity res = (FunctionDevicesEntity) query.getSingleResult();
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
