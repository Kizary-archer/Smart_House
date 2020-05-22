package app.DAO;

import app.DAO.DAOinterfaces.JournalErrorDAO;
import app.DAO.DAOinterfaces.UserRoleDAO;
import app.entityes.JournalErrorEntity;
import app.entityes.UserRoleEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public Collection<UserRoleEntity> getUserRole(int limit, int offset, UserRoleEntity userRoleEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<UserRoleEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(UserRoleEntity.class);
            Root<UserRoleEntity> root = criteriaBuilderQuery.from(UserRoleEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(userRoleEntity.getIdRole() != null){
                p.add(criteriaBuilder.equal(root.get("idRole"),userRoleEntity.getIdRole()));
            }
            if(userRoleEntity.getNameRole() != null){
                p.add(criteriaBuilder.like(root.get("nameRole"),userRoleEntity.getNameRole()));
            }
            if(userRoleEntity.getDescription() != null){
                p.add(criteriaBuilder.like(root.get("description"),userRoleEntity.getDescription()));
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
    public UserRoleEntity getPermissionUserRolesByIdRole(Long idRole) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  r " +
                    "from UserRoleEntity r " +
                    "left join fetch r.permissionUserRolesByIdRole " +
                    "where r.idRole = :idRole";
            Query query =  session.createQuery(hql);
            query.setParameter("idRole",idRole);
            UserRoleEntity res = (UserRoleEntity) query.getSingleResult();
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
    public UserRoleEntity getUsersByIdRole(Long idRole) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  r " +
                    "from UserRoleEntity r " +
                    "left join fetch r.usersByIdRole " +
                    "where r.idRole = :idRole";
            Query query =  session.createQuery(hql);
            query.setParameter("idRole",idRole);
            UserRoleEntity res = (UserRoleEntity) query.getSingleResult();
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
    public UserRoleEntity getUserRoleById(Long idRole) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UserRoleEntity where idRole = :idRole";
            Query query =  session.createQuery(hql);
            query.setParameter("idRole",idRole);
            UserRoleEntity res = (UserRoleEntity) query.getSingleResult();
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
