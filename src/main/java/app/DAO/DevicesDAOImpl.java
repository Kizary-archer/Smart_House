package app.DAO;

import app.DAO.DAOinterfaces.DevicesDAO;
import app.DAO.DAOinterfaces.UserDAO;
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
    public Collection<DeviceviewEntity> getDevicesView(int limit, int offset, DeviceviewEntity deviceviewEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<DeviceviewEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(DeviceviewEntity.class);
            Root<DeviceviewEntity> root = criteriaBuilderQuery.from(DeviceviewEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(deviceviewEntity.getIdDevice() != null){
                p.add(criteriaBuilder.equal(root.get("idDevice"),deviceviewEntity.getIdDevice()));
            }
            if(deviceviewEntity.getNameDevice() != null){
                p.add(criteriaBuilder.like(root.get("nameDevice"),deviceviewEntity.getNameDevice()));
            }
            if(deviceviewEntity.getNameController() != null){
                p.add(criteriaBuilder.like(root.get("nameController"),deviceviewEntity.getNameController()));
            }
            if(deviceviewEntity.getNameType() != null){
                p.add(criteriaBuilder.like(root.get("nameType"),deviceviewEntity.getNameType()));
            }
            if(deviceviewEntity.getNameStatus() != null){
                p.add(criteriaBuilder.like(root.get("nameStatus"),deviceviewEntity.getNameStatus()));
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
    public Collection<TypeDevicesEntity> getDeviceType() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from TypeDevicesEntity ";
            Query query =  session.createQuery(hql);
            Collection<TypeDevicesEntity> res = query.getResultList();
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
    public Collection<WorkStatusEntity> getDeviceWorkStatus() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from WorkStatusEntity ";
            Query query =  session.createQuery(hql);
            Collection<WorkStatusEntity> res = query.getResultList();
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
    public DevicesEntity getControllersByController(Long idDevice) {
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
    public DevicesEntity getTypeDevicesByTypeDevice(Long idDevice) {
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
    public DevicesEntity getWorkStatusByWorkStatus(Long idDevice) {
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
    public DevicesEntity getFunctionDevicesByIdDevice(Long idDevice) {
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
    public DevicesEntity getDeviceById(Long idDevice) {
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
