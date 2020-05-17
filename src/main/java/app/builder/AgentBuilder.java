package app.builder;

import app.entityes.AgentEntity;

import javax.servlet.http.HttpServletRequest;

public final class AgentBuilder {
    AgentEntity agentEntity = new AgentEntity();

    public AgentBuilder(HttpServletRequest request) {
        if (request.getParameter("idAgent") != null)
            if(!request.getParameter("idAgent").equals(""))
                agentEntity.setIdAgent(Integer.parseInt(request.getParameter("idAgent")));
        if (request.getParameter("name") != null)
            if (!request.getParameter("name").equals(""))
                agentEntity.setName(request.getParameter("name"));
        if (request.getParameter("surname") != null)
            if (!request.getParameter("surname").equals(""))
                agentEntity.setSurname(request.getParameter("surname"));
        if (request.getParameter("patronymic") != null)
            if (!request.getParameter("patronymic").equals(""))
                agentEntity.setPatronymic(request.getParameter("patronymic"));
        if (request.getParameter("phoneNumber") != null)
            if (!request.getParameter("phoneNumber").equals(""))
                agentEntity.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
        if (request.getParameter("percent") != null)
            if (!request.getParameter("percent").equals(""))
                agentEntity.setPercent(Integer.parseInt(request.getParameter("percent")));
    }
    public AgentEntity build() {
        return agentEntity;
    }
}
