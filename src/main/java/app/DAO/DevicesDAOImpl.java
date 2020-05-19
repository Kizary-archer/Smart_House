package app.DAO;

import app.DAO.DAOinterfaces.DevicesDAO;
import app.DAO.DAOinterfaces.UserDAO;
import app.entityes.DevicesEntity;
import app.entityes.UsersEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DevicesDAOImpl implements DevicesDAO {

    @Override
    public Collection<DevicesEntity> getDevices(int limit, int offset, DevicesEntity devicesEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<DevicesEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(DevicesEntity.class);
            Root<DevicesEntity> root = criteriaBuilderQuery.from(DevicesEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(devicesEntity.getIdDevice() != null){
                p.add(criteriaBuilder.equal(root.get("idDevice"),devicesEntity.getIdDevice()));
            }
            if(devicesEntity.getController() != null){
                p.add(criteriaBuilder.equal(root.get("controller"),devicesEntity.getController()));
            }
            if(devicesEntity.getTypeDevice() != null){
                p.add(criteriaBuilder.equal(root.get("typeDevice"),devicesEntity.getTypeDevice()));
            }
            if(devicesEntity.getStartDate() != null){
                p.add(criteriaBuilder.equal(root.get("startDate"),devicesEntity.getStartDate()));
            }
            if(devicesEntity.getWorkStatus() != null){
                p.add(criteriaBuilder.equal(root.get("workStatus"),devicesEntity.getWorkStatus()));
            }
            if(devicesEntity.getNameDevice() != null){
                p.add(criteriaBuilder.like(root.get("nameDevice"),devicesEntity.getNameDevice()));
            }
            if(devicesEntity.getDescription() != null){
                p.add(criteriaBuilder.like(root.get("description"),devicesEntity.getDescription()));
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
    public DevicesEntity getControllersByController(int idDevice) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  d " +
                    "from DevicesEntity d " +
                    "left join fetch d.controllersByController " +
                    "where d.idDevice = :idDevice";
            Query query =  session.createQuery(hql);
            query.setParameter("idDevice",idDevice);
            DevicesEntity res = (DevicesEntity) query.getSingleResult();
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
    public DevicesEntity getTypeDevicesByTypeDevice(int idDevice) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  d " +
                    "from DevicesEntity d " +
                    "left join fetch d.typeDevicesByTypeDevice " +
                    "where d.idDevice = :idDevice";
            Query query =  session.createQuery(hql);
            query.setParameter("idDevice",idDevice);
            DevicesEntity res = (DevicesEntity) query.getSingleResult();
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
    public DevicesEntity getWorkStatusByWorkStatus(int idDevice) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  d " +
                    "from DevicesEntity d " +
                    "left join fetch d.workStatusByWorkStatus " +
                    "where d.idDevice = :idDevice";
            Query query =  session.createQuery(hql);
            query.setParameter("idDevice",idDevice);
            DevicesEntity res = (DevicesEntity) query.getSingleResult();
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
    public DevicesEntity getFunctionDevicesByIdDevice(int idDevice) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  d " +
                    "from DevicesEntity d " +
                    "left join fetch d.functionDevicesByIdDevice " +
                    "where d.idDevice = :idDevice";
            Query query =  session.createQuery(hql);
            query.setParameter("idDevice",idDevice);
            DevicesEntity res = (DevicesEntity) query.getSingleResult();
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
    public DevicesEntity getDeviceById(int idDevice) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from DevicesEntity where idDevice = :idDevice";
            Query query =  session.createQuery(hql);
            query.setParameter("idDevice",idDevice);
            DevicesEntity res = (DevicesEntity) query.getSingleResult();
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
