package app.builder;

import app.entityes.ApartmentSaleEntity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public final class ApartmentSaleBuilder {
    ApartmentSaleEntity apartmentSaleEntity = new ApartmentSaleEntity();

    public ApartmentSaleBuilder(HttpServletRequest request) {
        if (request.getParameter("idSale") != null)
            if(!request.getParameter("idSale").equals(""))
                apartmentSaleEntity.setIdSale(Integer.parseInt(request.getParameter("idSale")));
        if (request.getParameter("apartment") != null)
            if (!request.getParameter("apartment").equals(""))
                apartmentSaleEntity.setApartment(Integer.parseInt(request.getParameter("apartment")));
        if (request.getParameter("ownerApartment") != null)
            if (!request.getParameter("ownerApartment").equals(""))
                apartmentSaleEntity.setOwnerApartment(Integer.parseInt(request.getParameter("ownerApartment")));
        if (request.getParameter("buyer") != null)
            if (!request.getParameter("buyer").equals(""))
                apartmentSaleEntity.setBuyer(Integer.parseInt(request.getParameter("buyer")));
        if (request.getParameter("agent") != null)
            if (!request.getParameter("agent").equals(""))
                apartmentSaleEntity.setAgent(Integer.parseInt(request.getParameter("agent")));
        if (request.getParameter("date") != null)
            if (!request.getParameter("date").equals(""))
                apartmentSaleEntity.setDate(Date.valueOf(request.getParameter("date")));
        if (request.getParameter("price") != null)
            if (!request.getParameter("price").equals(""))
                apartmentSaleEntity.setPrice(Integer.parseInt(request.getParameter("price")));
    }
    public ApartmentSaleEntity build() {
        return apartmentSaleEntity;
    }
}
