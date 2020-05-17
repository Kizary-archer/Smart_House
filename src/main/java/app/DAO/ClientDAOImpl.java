package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entityes.ClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public List<ClientEntity> getClients(int limit, int offset, ClientEntity clientEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ClientEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(ClientEntity.class);
            Root<ClientEntity> root = criteriaBuilderQuery.from(ClientEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(clientEntity.getIdClient() != null){
                p.add(criteriaBuilder.equal(root.get("idClient"),clientEntity.getIdClient()));
            }
            if(clientEntity.getName() != null){
                p.add(criteriaBuilder.like(root.get("name"),clientEntity.getName()));
            }
            if(clientEntity.getSurname() != null){
                p.add(criteriaBuilder.like(root.get("surname"),clientEntity.getSurname()));
            }
            if(clientEntity.getPatronymic() != null){
                p.add(criteriaBuilder.like(root.get("patronymic"),clientEntity.getPatronymic()));
            }
            if(clientEntity.getDateOfBirth() != null){
                p.add(criteriaBuilder.equal(root.get("dateOfBirth"),clientEntity.getDateOfBirth()));
            }
            if(clientEntity.getEmail() != null){
                p.add(criteriaBuilder.like(root.get("email"),clientEntity.getEmail()));
            }
            if(clientEntity.getGender() != null){
                p.add(criteriaBuilder.equal(root.get("gender"),clientEntity.getGender()));
            }
            if(clientEntity.getPhoneNumber() != null){
                p.add(criteriaBuilder.like(root.get("phoneNumber"),clientEntity.getPhoneNumber()));
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
    public ClientEntity getClientDocument(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.documentsClientsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
            ClientEntity res = (ClientEntity) query.getSingleResult();
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
    public ClientEntity getClientapartmentSales(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentSalesByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
            ClientEntity res = (ClientEntity) query.getSingleResult();
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
    public ClientEntity getClientapartments(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
            ClientEntity res = (ClientEntity) query.getSingleResult();
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
    public ClientEntity getClientById(int id) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from ClientEntity where idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",id);
            ClientEntity res = (ClientEntity) query.getSingleResult();
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
    public ClientEntity getClientAllChild(int idClient) {
        Session session = null;
        ClientEntity res;
        try {
            session = getSession();
            session.beginTransaction();

            String hqlApartments = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hqlApartments);
            query.setParameter("id",idClient);
            res = (ClientEntity) query.getSingleResult();

            String hqlApartmentsSale = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentSalesByIdClient " +
                    "where c.idClient = :id";
            query =  session.createQuery(hqlApartmentsSale);
            query.setParameter("id",idClient);
            res = (ClientEntity) query.getSingleResult();

            String hqlDocuments = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.documentsClientsByIdClient " +
                    "where c.idClient = :id";
            query =  session.createQuery(hqlDocuments);
            query.setParameter("id",idClient);
            res = (ClientEntity) query.getSingleResult();
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
