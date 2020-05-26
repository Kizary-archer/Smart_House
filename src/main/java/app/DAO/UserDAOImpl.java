package app.DAO;

import app.DAO.DAOinterfaces.UserDAO;
import app.entityes.JournalUserRequestViewEntity;
import app.entityes.UserStatusEntity;
import app.entityes.UsersEntity;
import app.entityes.UserviewEntity;
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
    public Collection<UserviewEntity> getUsersView(int limit, int offset, UserviewEntity userviewEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<UserviewEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(UserviewEntity.class);
            Root<UserviewEntity> root = criteriaBuilderQuery.from(UserviewEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(userviewEntity.getIdUser() != null){
                p.add(criteriaBuilder.equal(root.get("idUser"),userviewEntity.getIdUser()));
            }
            if(userviewEntity.getLogin() != null){
                p.add(criteriaBuilder.like(root.get("login"),userviewEntity.getLogin()));
            }
            if(userviewEntity.getRegistrationDate() != null){
                p.add(criteriaBuilder.equal(root.get("registrationDate"),userviewEntity.getRegistrationDate()));
            }
            if(userviewEntity.getStatusName() != null){
                p.add(criteriaBuilder.like(root.get("statusName"),userviewEntity.getStatusName()));
            }
            if(userviewEntity.getNameRole() != null){
                p.add(criteriaBuilder.equal(root.get("nameRole"),userviewEntity.getNameRole()));
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
    public Collection<JournalUserRequestViewEntity> getJournalUserRequestView(int limit, int offset, Long idUser) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  j " +
                    "from JournalUserRequestViewEntity j " +
                    "where j.idUser = :idUser";
            Query query = session.createQuery(hql);
            query.setParameter("idUser",idUser);
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
    public Collection<UserStatusEntity> getUserStatus() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UserStatusEntity ";
            Query query =  session.createQuery(hql);
            Collection<UserStatusEntity> res = query.getResultList();
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
    public UsersEntity getControllersByIdUser(Long idUser) {
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
    public UsersEntity getGroupFunctionsByIdUser(Long idUser) {
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
    public UsersEntity getJournalUserRequestsByIdUser(Long idUser) {
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
    public UsersEntity getUserRoleByRole(Long idUser) {
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
    public UsersEntity getUserStatusByStatus(Long idUser) {
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
    public UsersEntity getUserById(Long idUser) {
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
    public UsersEntity authorization(String login) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UsersEntity where login = :login";
            Query query =  session.createQuery(hql);
            query.setParameter("login",login);
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
    public UsersEntity getUserAllChild(Long idUser) {
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
