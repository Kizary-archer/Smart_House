package app.builder;

import app.entityes.HouseView;

import javax.servlet.http.HttpServletRequest;

public final class HouseViewBuilder {
    HouseView houseView = new HouseView();

    public HouseViewBuilder(HttpServletRequest request) {
        if (request.getParameter("idHouse") != null)
            if(!request.getParameter("idHouse").equals(""))
                houseView.setIdHouse(Integer.parseInt(request.getParameter("idHouse")));
        if (request.getParameter("numberHouse") != null)
            if (!request.getParameter("numberHouse").equals(""))
                houseView.setNumberHouse(request.getParameter("numberHouse"));
        if (request.getParameter("nameSeries") != null)
            if (!request.getParameter("nameSeries").equals(""))
                houseView.setNameSeries(request.getParameter("nameSeries"));
        if (request.getParameter("nameStreet") != null)
            if (!request.getParameter("nameStreet").equals(""))
                houseView.setNameStreet(request.getParameter("nameStreet"));
        if (request.getParameter("nameDistrict") != null)
            if (!request.getParameter("nameDistrict").equals(""))
                houseView.setNameDistrict(request.getParameter("nameDistrict"));
        if (request.getParameter("nameCity") != null)
            if (!request.getParameter("nameCity").equals(""))
                houseView.setNameCity(request.getParameter("nameCity"));
    }
    public HouseView build() {
        return houseView;
    }
}
