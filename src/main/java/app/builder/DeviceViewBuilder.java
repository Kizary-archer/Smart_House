package app.builder;

import app.entityes.DevicesEntity;
import app.entityes.DeviceviewEntity;
import app.entityes.UsersEntity;

import javax.servlet.http.HttpServletRequest;

public final class DeviceViewBuilder {
    DeviceviewEntity deviceviewEntity = new DeviceviewEntity();

    public DeviceViewBuilder(HttpServletRequest request) {
        if ((request.getParameter("idDevice") != null)&&(!request.getParameter("idDevice").equals("")))
            deviceviewEntity.setIdDevice(Long.valueOf(request.getParameter("idDevice")));
        if ((request.getParameter("nameDevice") != null)&&(!request.getParameter("nameDevice").equals("")))
                deviceviewEntity.setNameDevice(request.getParameter("nameDevice"));
        if ((request.getParameter("nameController") != null)&&(!request.getParameter("nameController").equals("")))
            deviceviewEntity.setNameController(request.getParameter("nameController"));
        if ((request.getParameter("nameType") != null)&&(!request.getParameter("nameType").equals("")))
            deviceviewEntity.setNameType((request.getParameter("nameType")));
        if ((request.getParameter("nameStatus") != null)&&(!request.getParameter("nameStatus").equals("")))
            deviceviewEntity.setNameStatus((request.getParameter("nameStatus")));
    }
    public DeviceviewEntity build() {
        return deviceviewEntity;
    }
}
