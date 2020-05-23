package app.controllers;

import app.builder.DeviceViewBuilder;
import app.builder.UserBuilder;
import app.builder.UserRoleBuilder;
import app.builder.UserViewBuilder;
import app.entityes.*;
import app.services.ControllerService;
import app.services.DeviceService;
import app.services.UserRoleService;
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

@WebServlet(urlPatterns = {"/DTDeviceView"})
public class DeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        ControllerService controllerService = new ControllerService();
        DeviceService deviceService = new DeviceService();
        List<TypeDevicesEntity> typeDevicesEntityList = (List<TypeDevicesEntity>) deviceService.getDeviceType();
        List<WorkStatusEntity> workStatusEntityList = (List<WorkStatusEntity>) deviceService.getDeviceWorkStatus();
        request.setAttribute("roles",userRoleEntityList);
        request.setAttribute("statuses",userStatusEntityList);
        if(request.getServletPath().equals("/addUser")) {
            requestDispatcher = request.getRequestDispatcher("view/addUser.jsp");
        }else {
            UsersEntity usersEntity = userService.getUserById(Long.valueOf(request.getParameter("idUser")));
            request.setAttribute("user", usersEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewUser.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        DeviceService deviceService = new DeviceService();

        if(request.getServletPath().equals("/DTDeviceView")) {
            DeviceviewEntity deviceviewEntity = null;
            try {
                deviceviewEntity = new DeviceViewBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<DeviceviewEntity> deviceViewEntityList = (List<DeviceviewEntity>) deviceService.getDevicesView(1000,0,deviceviewEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(deviceViewEntityList);
            response.getWriter().write(json);
        }
    }
}


