package app.controllers;

import app.builder.ApartmentBuilder;
import app.builder.HouseViewBuilder;
import app.entityes.*;
import app.services.ApartmentService;
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

@WebServlet(urlPatterns = {"/addApartment","/searchHouse","/updApartment","/viewApartment","/delApartment","/listApartments","/DTApart"})
public class ApartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
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
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ApartmentService apartmentService = new ApartmentService();
        ApartmentEntity apartmentEntity = null;
        try {
            apartmentEntity = new ApartmentBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

       if(request.getServletPath().equals("/addApartment")) {
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
        }
    }
}


