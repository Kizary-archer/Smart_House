package app.builder;

import app.entityes.ApartmentEntity;

import javax.servlet.http.HttpServletRequest;

public final class ApartmentBuilder {
    ApartmentEntity apartmentEntity = new ApartmentEntity();

    public ApartmentBuilder(HttpServletRequest request) {
        if (request.getParameter("idApartment") != null)
            if(!request.getParameter("idApartment").equals(""))
                apartmentEntity.setIdApartment(Integer.parseInt(request.getParameter("idApartment")));
        if (request.getParameter("numberApartment") != null)
            if (!request.getParameter("numberApartment").equals(""))
                apartmentEntity.setNumberApartment(Integer.parseInt(request.getParameter("numberApartment")));
        if (request.getParameter("countRoom") != null)
            if (!request.getParameter("countRoom").equals(""))
                apartmentEntity.setCountRoom(Integer.parseInt(request.getParameter("countRoom")));
        if (request.getParameter("livingSpace") != null)
            if (!request.getParameter("livingSpace").equals(""))
                apartmentEntity.setLivingSpace(Float.parseFloat(request.getParameter("livingSpace")));
        if (request.getParameter("house") != null)
            if (!request.getParameter("house").equals(""))
                apartmentEntity.setHouse(Integer.parseInt(request.getParameter("house")));
        if (request.getParameter("apartmentOwner") != null)
            if (!request.getParameter("apartmentOwner").equals(""))
                apartmentEntity.setApartmentOwner(Integer.parseInt(request.getParameter("apartmentOwner")));
        if (request.getParameter("meterPrice") != null)
            if (!request.getParameter("meterPrice").equals(""))
                apartmentEntity.setMeterPrice(Integer.parseInt(request.getParameter("meterPrice")));
    }
    public ApartmentEntity build() {
        return apartmentEntity;
    }
}
