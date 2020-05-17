package app.DAO;

import app.DAO.DAOinterfaces.ApartmentSaleDAO;
import app.entityes.ApartmentSaleEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApartmentSaleDAOImpl implements ApartmentSaleDAO {

    @Override
    public List<ApartmentSaleEntity> getApartmentSales(int limit, int offset, ApartmentSaleEntity apartmentSaleEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ApartmentSaleEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(ApartmentSaleEntity.class);
            Root<ApartmentSaleEntity> root = criteriaBuilderQuery.from(ApartmentSaleEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(apartmentSaleEntity.getIdSale() != null){
                p.add(criteriaBuilder.equal(root.get("idSale"),apartmentSaleEntity.getIdSale()));
            }
            if(apartmentSaleEntity.getApartment() != null){
                p.add(criteriaBuilder.equal(root.get("apartment"),apartmentSaleEntity.getApartment()));
            }
            if(apartmentSaleEntity.getOwnerApartment() != null){
                p.add(criteriaBuilder.equal(root.get("ownerApartment"),apartmentSaleEntity.getOwnerApartment()));
            }
            if(apartmentSaleEntity.getBuyer() != null){
                p.add(criteriaBuilder.equal(root.get("buyer"),apartmentSaleEntity.getBuyer()));
            }
            if(apartmentSaleEntity.getAgent() != null){
                p.add(criteriaBuilder.equal(root.get("agent"),apartmentSaleEntity.getAgent()));
            }
            if(apartmentSaleEntity.getDate() != null){
                p.add(criteriaBuilder.equal(root.get("date"),apartmentSaleEntity.getDate()));
            }
            if(apartmentSaleEntity.getPrice() != null){
                p.add(criteriaBuilder.equal(root.get("price"),apartmentSaleEntity.getPrice()));
            }
            if(!p.isEmpty()) {
                Predicate[] pr = new Predicate[p.size()];
                p.toArray(pr);
                criteriaBuilderQuery.where((pr));
            }
            Query query = session.createQuery(criteriaBuilderQuery);
           if(limit != 0) query.setMaxResults(limit);
            query.setFirstResult(offset);
            List<ApartmentSaleEntity> res = query.getResultList();
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
    public ApartmentSaleEntity getApartmentSaleById(int idApartmentSale) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from ApartmentSaleEntity where idSale = :idApartmentSale";
            Query query =  session.createQuery(hql);
            query.setParameter("idApartmentSale",idApartmentSale);
            ApartmentSaleEntity res = (ApartmentSaleEntity) query.getSingleResult();
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
