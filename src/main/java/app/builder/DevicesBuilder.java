package app.builder;

import app.entityes.DevicesEntity;
import app.entityes.DeviceviewEntity;

import javax.servlet.http.HttpServletRequest;

public final class DevicesBuilder {
    DevicesEntity deviceViewEntity = new DevicesEntity();

    public DevicesBuilder(HttpServletRequest request) {
        if ((request.getParameter("idDevice") != null)&&(!request.getParameter("idDevice").equals("")))
            deviceViewEntity.setIdDevice(Long.valueOf(request.getParameter("idDevice")));
        if ((request.getParameter("controller") != null)&&(!request.getParameter("controller").equals("")))
                deviceViewEntity.setController(Long.valueOf(request.getParameter("controller")));
        if ((request.getParameter("typeDevice") != null)&&(!request.getParameter("typeDevice").equals("")))
            deviceViewEntity.setTypeDevice(Long.valueOf(request.getParameter("typeDevice")));
        if ((request.getParameter("workStatus") != null)&&(!request.getParameter("workStatus").equals("")))
            deviceViewEntity.setWorkStatus(Long.valueOf(request.getParameter("workStatus")));
        if ((request.getParameter("nameDevice") != null)&&(!request.getParameter("nameDevice").equals("")))
            deviceViewEntity.setNameDevice(request.getParameter("v"));
        if ((request.getParameter("description") != null)&&(!request.getParameter("description").equals("")))
            deviceViewEntity.setDescription((request.getParameter("description")));
    }
    public DevicesEntity build() {
        return deviceViewEntity;
    }
}
