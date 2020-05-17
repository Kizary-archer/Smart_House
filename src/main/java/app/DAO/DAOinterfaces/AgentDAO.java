package app.DAO.DAOinterfaces;

import app.entityes.AgentEntity;

import java.util.Collection;

public interface AgentDAO extends DAOMain<AgentEntity> {

    public Collection<AgentEntity> getAgents(int limit, int offset, AgentEntity agentEntity);
    public AgentEntity getAgentAllChild(int idClient);
    public AgentEntity getAgentById(int idClient);
}
