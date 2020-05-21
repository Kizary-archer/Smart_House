package app.controllers;

import app.builder.UserBuilder;
import app.builder.UserRoleBuilder;
import app.entityes.UserRoleEntity;
import app.entityes.UserviewEntity;
import app.services.UserRoleService;
import app.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/DTUserView","/DTUserRoleView"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        /*RequestDispatcher requestDispatcher = null;
        ApartmentService apartmentService = new ApartmentService();
       if(request.getServletPath().equals("/listApartments")) {
           requestDispatcher = request.getRequestDispatcher("view/listApartments.jsp");
           requestDispatcher.forward(request, response);
       }
        if(request.getServletPath().equals("/addApartment")) {
            request.setAttribute("apartmentOwner", request.getParameter("idClient"));
            requestDispatcher = request.getRequestDispatcher("view/addApartment.jsp");
        }else { //вывод отпеделёной кв. или её обновление
            ApartmentEntity apartmentEntity = apartmentService.getApartmentAllChild(Integer.parseInt(request.getParameter("idApartment")));//получение определённой квартиры из бд
            request.setAttribute("apartment", apartmentEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewApartment.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);*/
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        UserService userService = new UserService();
        UserRoleService userRoleService = new UserRoleService();

        if(request.getServletPath().equals("/DTUserView")) {
            UserviewEntity userviewEntity = null;
            try {
                userviewEntity = new UserBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<UserviewEntity> userviewEntityList = (List<UserviewEntity>) userService.getUsersView(1000,0,userviewEntity);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson(userviewEntityList);
            response.getWriter().write(json);
        }

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
       /*if(request.getServletPath().equals("/addApartment")) {
           if (apartmentService.addApartment(apartmentEntity)) {
               request.setAttribute("isApartmentAdded", "true");
           }
           else request.setAttribute("isApartmentAdded", "false");
           doGet(request, response);
        }

        if(request.getServletPath().equals("/searchHouse")) {
            HouseView houseView = null;
            try {
                houseView = new HouseViewBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<HouseView> houseEntityList = (List<HouseView>) apartmentService.getHouses(1000,0,houseView);
            String json = new Gson().toJson(houseEntityList);
            response.getWriter().write(json);
        }

        if(request.getServletPath().equals("/DTApart")) {
            List<ApartmentEntity> apartmentEntityList = (List<ApartmentEntity>) apartmentService.getApartmentsList(1000,0,apartmentEntity);
            Gson gson = new GsonBuilder()
                                        .excludeFieldsWithoutExposeAnnotation()
                                        .create();
            String json = gson.toJson(apartmentEntityList);
            response.getWriter().write(json);
        }

        if(request.getServletPath().equals("/updApartment")) {
            if (apartmentService.updApartment(apartmentEntity)) {
                request.setAttribute("isApartmentUpd", "true");
            }
            else {
                request.setAttribute("isApartmentUpd", "false");
            }
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delApartment")) {
            if (apartmentService.delApartment(apartmentEntity)) {
                request.setAttribute("isApartmentdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isApartmentdel", "false");
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listApartments")) {
            List<ApartmentEntity> apartmentEntityList = new ArrayList<ApartmentEntity>(apartmentService.getApartmentsList(1000, 0,apartmentEntity));
            request.setAttribute("apartments",apartmentEntityList);
            doGet(request, response);
        }*/
    }
}


