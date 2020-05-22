package app.DAO;

import app.DAO.DAOinterfaces.ControllersDAO;
import app.DAO.DAOinterfaces.UserDAO;
import app.entityes.ControllersEntity;
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

public class ControllersDAOImpl implements ControllersDAO {

    @Override
    public Collection<ControllersEntity> getUsers(int limit, int offset, ControllersEntity controllersEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ControllersEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(ControllersEntity.class);
            Root<ControllersEntity> root = criteriaBuilderQuery.from(ControllersEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(controllersEntity.getIdController() != null){
                p.add(criteriaBuilder.equal(root.get("idController"),controllersEntity.getIdController()));
            }
            if(controllersEntity.getUser() != null){
                p.add(criteriaBuilder.equal(root.get("user"),controllersEntity.getUser()));
            }
            if(controllersEntity.getModel() != null){
                p.add(criteriaBuilder.equal(root.get("model"),controllersEntity.getModel()));
            }
            if(controllersEntity.getStartDate() != null){
                p.add(criteriaBuilder.equal(root.get("startDate"),controllersEntity.getStartDate()));
            }
            if(controllersEntity.getWorkStatus() != null){
                p.add(criteriaBuilder.equal(root.get("workStatus"),controllersEntity.getWorkStatus()));
            }
            if(controllersEntity.getNameController() != null){
                p.add(criteriaBuilder.like(root.get("nameController"),controllersEntity.getNameController()));
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
    public ControllersEntity getControllerModelByModel(Long idController) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ControllersEntity c " +
                    "left join fetch c.controllerModelByModel " +
                    "where c.idController = :idController";
            Query query =  session.createQuery(hql);
            query.setParameter("idController",idController);
            ControllersEntity res = (ControllersEntity) query.getSingleResult();
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
    public ControllersEntity getWorkStatusByWorkStatus(Long idController) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ControllersEntity c " +
                    "left join fetch c.workStatusByWorkStatus " +
                    "where c.idController = :idController";
            Query query =  session.createQuery(hql);
            query.setParameter("idController",idController);
            ControllersEntity res = (ControllersEntity) query.getSingleResult();
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
    public ControllersEntity getDevicesByIdController(Long idController) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ControllersEntity c " +
                    "left join fetch c.devicesByIdController " +
                    "where c.idController = :idController";
            Query query =  session.createQuery(hql);
            query.setParameter("idController",idController);
            ControllersEntity res = (ControllersEntity) query.getSingleResult();
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
    public ControllersEntity getGroupsControllersByIdController(Long idController) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ControllersEntity c " +
                    "left join fetch c.groupsControllersByIdController " +
                    "where c.idController = :idController";
            Query query =  session.createQuery(hql);
            query.setParameter("idController",idController);
            ControllersEntity res = (ControllersEntity) query.getSingleResult();
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
    public ControllersEntity getControllerById(Long idController) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from ControllersEntity where idController = :idController";
            Query query =  session.createQuery(hql);
            query.setParameter("idController",idController);
            ControllersEntity res = (ControllersEntity) query.getSingleResult();
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
