package app.controllers;

import app.builder.AgentBuilder;
import app.entityes.AgentEntity;
import app.services.AgentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/listAgents","/addAgent","/delAgent","/updAgent","/viewAgent","/DTAgent"})
public class AgentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        if(request.getServletPath().equals("/listAgents")) {
            requestDispatcher = request.getRequestDispatcher("view/listAgents.jsp");
        }
        if(request.getServletPath().equals("/addAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/addAgent.jsp");
        }
        if(request.getServletPath().equals("/delAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
        }
        if(request.getServletPath().equals("/updAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
        }
        if(request.getServletPath().equals("/viewAgent")) {
            AgentService agentService = new AgentService();
            AgentEntity agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого клиента из бд
            request.setAttribute("agent", agentEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
            }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        AgentService agentService = new AgentService();
        AgentEntity agentEntity = new AgentBuilder(request).build();

        if(request.getServletPath().equals("/DTAgent")) {
            List<AgentEntity> agentEntityList = (List<AgentEntity>) agentService.getAgents(1000,0,agentEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(agentEntityList);
            response.getWriter().write(json);
        }
        if(request.getServletPath().equals("/addAgent")) {
            if (agentService.addAgent(agentEntity)) {
                request.setAttribute("isAgentAdded", "true");
            }
            else request.setAttribute("isAgentAdded", "false");
            doGet(request, response);
        }
        if(request.getServletPath().equals("/updAgent")) {
            if (agentService.updAgent(agentEntity)) {
                request.setAttribute("isAgentUpd", "true");
            }
            else {
                request.setAttribute("isAgentUpd", "false");
            }
            agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого агента из бд
            request.setAttribute("agent", agentEntity);
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delAgent")) {
            if (agentService.delAgent(agentEntity)) {
                request.setAttribute("isAgentdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isAgentdel", "false");
                agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого агента из бд
                request.setAttribute("agent", agentEntity);
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listAgents")) {
            List<AgentEntity> agentData = new ArrayList<>(agentService.getAgents(1000, 0, agentEntity));
            request.setAttribute("agents",agentData);
            doGet(request, response);
        }
    }
}


