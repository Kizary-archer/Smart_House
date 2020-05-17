package app.DAO;

import app.DAO.DAOinterfaces.AgentDAO;
import app.entityes.AgentEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AgentDAOImpl implements AgentDAO {

    @Override
    public List<AgentEntity> getAgents(int limit, int offset, AgentEntity agentEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<AgentEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(AgentEntity.class);
            Root<AgentEntity> root = criteriaBuilderQuery.from(AgentEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(agentEntity.getIdAgent() != null){
                p.add(criteriaBuilder.equal(root.get("idAgent"),agentEntity.getIdAgent()));
            }
            if(agentEntity.getName() != null){
                p.add(criteriaBuilder.like(root.get("name"),agentEntity.getName()));
            }
            if(agentEntity.getSurname() != null){
                p.add(criteriaBuilder.like(root.get("surname"),agentEntity.getSurname()));
            }
            if(agentEntity.getPatronymic() != null){
                p.add(criteriaBuilder.like(root.get("patronymic"),agentEntity.getPatronymic()));
            }
            if(agentEntity.getPercent() != null){
                p.add(criteriaBuilder.equal(root.get("percent"),agentEntity.getPercent()));
            }
            if(agentEntity.getPhoneNumber() != null){
                p.add(criteriaBuilder.equal(root.get("phoneNumber"),agentEntity.getPhoneNumber()));
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
    public AgentEntity getAgentAllChild(int idAgent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  a " +
                    "from AgentEntity a " +
                    "left join fetch a.apartmentSalesByIdAgent " +
                    "where a.idAgent = :idAgent";
            Query query =  session.createQuery(hql);
            query.setParameter("idAgent",idAgent);
            AgentEntity res = (AgentEntity) query.getSingleResult();
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
    public AgentEntity getAgentById(int idAgent) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from AgentEntity where idAgent = :idAgent";
            Query query =  session.createQuery(hql);
            query.setParameter("idAgent",idAgent);
            AgentEntity res = (AgentEntity) query.getSingleResult();
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
