package app.controllers;

import app.builder.ApartmentSaleBuilder;
import app.entityes.ApartmentSaleEntity;
import app.services.ApartmentSaleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/addApartmentSale","/updApartmentSale","/viewApartmentSale","/delApartmentSale","/listApartmentSales"})
public class ApartmentSaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        ApartmentSaleService apartmentSaleService = new ApartmentSaleService();
       if(request.getServletPath().equals("/listApartmentSales")) {
           requestDispatcher = request.getRequestDispatcher("view/listApartmentSales.jsp");
           requestDispatcher.forward(request, response);
       }
        if(request.getServletPath().equals("/addApartmentSale")) {
            requestDispatcher = request.getRequestDispatcher("view/addApartmentSale.jsp");
        }else { //вывод отпеделёной кв. или её обновление
            ApartmentSaleEntity apartmentSaleEntity = apartmentSaleService.getApartmentById(Integer.parseInt(request.getParameter("idSale")));//получение определённой квартиры из бд
            request.setAttribute("apartmentSale", apartmentSaleEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewApartmentSale.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ApartmentSaleService apartmentSaleService = new ApartmentSaleService();
        ApartmentSaleEntity apartmentSaleEntity = null;
        try {
            apartmentSaleEntity = new ApartmentSaleBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

       if(request.getServletPath().equals("/addApartmentSale")) {
           if (apartmentSaleService.addApartment(apartmentSaleEntity)) {
               request.setAttribute("isApartmentSaleAdded", "true");
           }
           else request.setAttribute("isApartmentSaleAdded", "false");
           doGet(request, response);
        }

        if(request.getServletPath().equals("/updApartmentSale")) {
            if (apartmentSaleService.updApartment(apartmentSaleEntity)) {
                request.setAttribute("isApartmentSaleUpd", "true");
            }
            else {
                request.setAttribute("isApartmentSaleUpd", "false");
            }
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delApartmentSale")) {
            if (apartmentSaleService.delApartment(apartmentSaleEntity)) {
                request.setAttribute("isApartmentSaleDel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isApartmentSaleDel", "false");
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listApartmentSales")) {
            List<ApartmentSaleEntity> apartmentSaleEntityList = new ArrayList<ApartmentSaleEntity>(
                    apartmentSaleService.getApartmentSales(1000, 0,apartmentSaleEntity));
            request.setAttribute("apartmentSales",apartmentSaleEntityList);
            doGet(request, response);
        }
    }
}


