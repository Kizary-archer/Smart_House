package app.DAO;

import app.DAO.DAOinterfaces.UserDAO;
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

public class UserDAOImpl implements UserDAO {


    @Override
    public Collection<UsersEntity> getUsers(int limit, int offset, UsersEntity usersEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<UsersEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(UsersEntity.class);
            Root<UsersEntity> root = criteriaBuilderQuery.from(UsersEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(usersEntity.getIdUser() != null){
                p.add(criteriaBuilder.equal(root.get("idUser"),usersEntity.getIdUser()));
            }
            if(usersEntity.getLogin() != null){
                p.add(criteriaBuilder.like(root.get("login"),usersEntity.getLogin()));
            }
            if(usersEntity.getPassword() != null){
                p.add(criteriaBuilder.like(root.get("password"),usersEntity.getPassword()));
            }
            if(usersEntity.getRegistrationDate() != null){
                p.add(criteriaBuilder.equal(root.get("registrationDate"),usersEntity.getRegistrationDate()));
            }
            if(usersEntity.getStatus() != null){
                p.add(criteriaBuilder.equal(root.get("status"),usersEntity.getStatus()));
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
    public UsersEntity getControllersByIdUser(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.controllersByIdUser " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getGroupFunctionsByIdUser(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.groupFunctionsByIdUser " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getJournalUserRequestsByIdUser(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.journalUserRequestsByIdUser " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getUserRoleByRole(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.userRoleByRole " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getUserStatusByStatus(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.userStatusByStatus " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getUserById(int idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UsersEntity where idUser = :idUser";
            Query query =  session.createQuery(hql);
            query.setParameter("idUser",idUser);
            UsersEntity res = (UsersEntity) query.getSingleResult();
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
    public UsersEntity getUserAllChild(int idUser) {
        Session session = null;
        UsersEntity res;
        try {
            session = getSession();
            session.beginTransaction();


            String hqlControllers =  "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.controllersByIdUser " +
                    "where u.idUser = :idUser";
            Query query =  session.createQuery(hqlControllers);
            query.setParameter("idUser",idUser);
            res = (UsersEntity) query.getSingleResult();

            String hqlGroupFunctions =  "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.groupFunctionsByIdUser " +
                    "where u.idUser = :idUser";
            query =  session.createQuery(hqlGroupFunctions);
            query.setParameter("idUser",idUser);
            res = (UsersEntity) query.getSingleResult();

            String hqlDocumentsjournalUser =  "select distinct  u " +
                    "from UsersEntity u " +
                    "left join fetch u.userStatusByStatus " +
                    "where u.idUser = :idUser";
            query =  session.createQuery(hqlDocumentsjournalUser);
            query.setParameter("idUser",idUser);
            res = (UsersEntity) query.getSingleResult();
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