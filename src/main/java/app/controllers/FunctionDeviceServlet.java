package app.controllers;

import app.builder.DeviceViewBuilder;
import app.builder.DevicesBuilder;
import app.builder.FunctionDeviceBuilder;
import app.domain.*;
import app.services.DeviceService;
import app.services.FunctionDeviceService;
import app.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/viewFunc","/addFunc","/updFunc","/delFunc","/deviceFuncData"})
public class FunctionDeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        FunctionDeviceService functionDeviceService = new FunctionDeviceService();
        DeviceService deviceService = new DeviceService();
        List<TypeFunctionEntity> typeFunctionEntityList = (List<TypeFunctionEntity>) functionDeviceService.getTypeFunctions();
        List<DevicesEntity> devicesEntityList = (List<DevicesEntity>) deviceService.getDevices(0,0,new DevicesEntity());
        request.setAttribute("typesFunc",typeFunctionEntityList);
        request.setAttribute("devices",devicesEntityList);

        if(request.getServletPath().equals("/addFunc")){
            requestDispatcher = request.getRequestDispatcher("view/addFuncDevice.jsp");
        }else {
            FunctionDevicesEntity functionDevicesEntity = functionDeviceService.getFunctionDeviceById(Long.valueOf(request.getParameter("idFunction")));
           // functionDevicesEntity.getTypeFunctionByTypeFunction().getRange()
            request.setAttribute("function", functionDevicesEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewFuncDevice.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        FunctionDeviceService functionDeviceService = new FunctionDeviceService();
        if(request.getServletPath().equals("/deviceFuncData")) {
            String res = functionDeviceService.getFunctionDataJson(Long.valueOf(request.getParameter("idFunction")));
            response.getWriter().write(res);
        }
        else{
            FunctionDevicesEntity functionDevicesEntity = null;
            try {
                functionDevicesEntity = new FunctionDeviceBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }

        /////CRUD////////
                if(request.getServletPath().equals("/addFunc")) {
                    if (functionDeviceService.addFunctionDevice(functionDevicesEntity)) {
                        request.setAttribute("isFuncAdded", "true");
                    }
                    else request.setAttribute("isFuncAdded", "false");
                    doGet(request, response);
                }
                if(request.getServletPath().equals("/updFunc")) {
                    if (functionDeviceService.updFunctionDevice(functionDevicesEntity)) {
                        request.setAttribute("isFuncupd", "true");
                        UserService userService = new UserService();
                        HttpSession session = request.getSession();
                        UsersEntity authUser = (UsersEntity) session.getAttribute("authUser");//получение авторизованного пользователя из сессии
                        userService.UserRequest(authUser,functionDevicesEntity);
                    }
                    else request.setAttribute("isFuncupd", "false");
                    doGet(request, response);
                }
                if(request.getServletPath().equals("/delFunc")) {
                    if (functionDeviceService.delFunctionDevice(functionDevicesEntity)) {
                        request.setAttribute("isFuncdel", "true");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    else request.setAttribute("isFuncdel", "false");
                    doGet(request, response);
                }
        }
/////////////////////
    }
}


