package app.controllers;

import app.builder.JournalErrorViewBuilder;
import app.builder.JournalEventViewBuilder;
import app.builder.UserRoleBuilder;
import app.domain.JournalErrorViewEntity;
import app.domain.JournalEventViewEntity;
import app.services.JournalErrorService;
import app.services.JournalEventService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin","/DTJournalEventView","/DTJournalErrorView"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        if (request.getServletPath().equals("/admin")) {
            requestDispatcher = request.getRequestDispatcher("view/adminPanel.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JournalEventService journalEventService = new JournalEventService();
        JournalErrorService journalErrorService = new JournalErrorService();
        if (request.getServletPath().equals("/DTJournalEventView")) {
            JournalEventViewEntity journalEventViewEntity = null;
            try {
                journalEventViewEntity = new JournalEventViewBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<JournalEventViewEntity> journalEventViewEntityList = (List<JournalEventViewEntity>) journalEventService.getJournalViewEvents(1000, 0, journalEventViewEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(journalEventViewEntityList);
            response.getWriter().write(json);
        }

        if(request.getServletPath().equals("/DTJournalErrorView")){
            JournalErrorViewEntity journalErrorViewEntity = null;
            try {
                journalErrorViewEntity = new JournalErrorViewBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<JournalErrorViewEntity> journalErrorViewEntityList = (List<JournalErrorViewEntity>) journalErrorService.getJournalErrorView(1000, 0, journalErrorViewEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(journalErrorViewEntityList);
            response.getWriter().write(json);
        }
    }
}



