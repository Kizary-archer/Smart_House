package app.services;

import app.DAO.DAOinterfaces.AgentDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.*;

import java.util.Collection;

public class AgentService {

    public boolean addAgent(AgentEntity agentEntity){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.add(agentEntity);
    }
    public boolean delAgent(AgentEntity agentEntity){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.delete(agentEntity);
    }
    public boolean updAgent(AgentEntity agentEntity){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.update(agentEntity);
    }
    public AgentEntity getAgentById(int idAgent){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.getAgentById(idAgent);
    }
    public Collection<AgentEntity> getAgents(int limit,int offset,AgentEntity agentEntity){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.getAgents(limit,offset,agentEntity);
    }

    public AgentEntity getAgentAllData(int idClient){
        AgentDAO agentDAO = DAOCreateFactoryUtil.getInstance().getAgentDAO();
        return  agentDAO.getAgentAllChild(idClient);
    }
}
