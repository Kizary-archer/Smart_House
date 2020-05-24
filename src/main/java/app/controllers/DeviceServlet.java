package app.controllers;

import app.builder.*;
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

@WebServlet(urlPatterns = {"/DTDeviceView","/addDevice","/delDevice","/updDevice","/viewDevice","/deviceFuncData"})
public class DeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        ControllerService controllerService = new ControllerService();
        DeviceService deviceService = new DeviceService();
        List<TypeDevicesEntity> typeDevicesEntityList = (List<TypeDevicesEntity>) deviceService.getDeviceType();
        List<WorkStatusEntity> workStatusEntityList = (List<WorkStatusEntity>) deviceService.getDeviceWorkStatus();
        List<ControllersEntity> controllersEntityList = (List<ControllersEntity>) controllerService.getControllers(0,0,new ControllersEntity());
        request.setAttribute("types",typeDevicesEntityList);
        request.setAttribute("statuses",workStatusEntityList);
        request.setAttribute("controllers",controllersEntityList);

        if(request.getServletPath().equals("/addDevice")) {
            requestDispatcher = request.getRequestDispatcher("view/addDevice.jsp");
        }else {
            DevicesEntity devicesEntity = deviceService.getDeviceById(Long.valueOf(request.getParameter("idDevice")));
            request.setAttribute("device", devicesEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewDevice.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        DeviceService deviceService = new DeviceService();
        DevicesEntity devicesEntity = null;
        try {
            devicesEntity = new DevicesBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        /////CRUD////////
        if(request.getServletPath().equals("/addDevice")) {
            if (deviceService.addDevice(devicesEntity)) {
                request.setAttribute("isDeviceAdded", "true");
            }
            else request.setAttribute("isDeviceAdded", "false");
            doGet(request, response);
        }
        if(request.getServletPath().equals("/updDevice")) {
            if (deviceService.updDevice(devicesEntity)) {
                request.setAttribute("isDeviceupd", "true");
            }
            else request.setAttribute("isDeviceupd", "false");
            doGet(request, response);
        }
        if(request.getServletPath().equals("/delDevice")) {
            if (deviceService.delDevice(devicesEntity)) {
                request.setAttribute("isDevicedel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else request.setAttribute("isDevicedel", "false");
            doGet(request, response);
        }
        if(request.getServletPath().equals("/deviceFuncData")) {
            String s = "[[527082200000,188.36  ],[1527168600000,188.15],[1527255000000,188.58],[1527600600000,187.9]]";
            response.getWriter().write(s);
        }
/////////////////////
    }
}


