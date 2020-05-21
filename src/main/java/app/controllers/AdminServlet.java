package app.controllers;

import app.builder.UserRoleBuilder;
import app.entityes.UserRoleEntity;
import app.entityes.UserviewEntity;
import app.services.UserService;
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

@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
       if(request.getServletPath().equals("/admin")) {
           requestDispatcher = request.getRequestDispatcher("view/adminPanel.jsp");
           requestDispatcher.forward(request, response);
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        if(request.getServletPath().equals("/DTUserRoleView")) {
            UserRoleEntity userRoleEntity = null;
            try {
                userRoleEntity = new UserRoleBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<UserRoleEntity> userRoleEntityList = (List<UserRoleEntity>) userRoleService.getUserRole(1000,0,userRoleEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(userRoleEntityList);
            response.getWriter().write(json);
        }

    }
}


