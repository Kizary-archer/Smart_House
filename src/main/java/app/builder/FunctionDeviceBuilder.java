package app.builder;

import app.entityes.DevicesEntity;
import app.entityes.FunctionDevicesEntity;

import javax.servlet.http.HttpServletRequest;

public final class FunctionDeviceBuilder {
    FunctionDevicesEntity functionDevicesEntity = new FunctionDevicesEntity();

    public FunctionDeviceBuilder(HttpServletRequest request) {
        if ((request.getParameter("idFunction") != null)&&(!request.getParameter("idFunction").equals("")))
            functionDevicesEntity.setIdFunction(Long.valueOf(request.getParameter("idFunction")));
        if ((request.getParameter("device") != null)&&(!request.getParameter("device").equals("")))
                functionDevicesEntity.setDevice(Long.valueOf(request.getParameter("device")));
        if ((request.getParameter("typeFunction") != null)&&(!request.getParameter("typeFunction").equals("")))
            functionDevicesEntity.setTypeFunction(Long.valueOf(request.getParameter("typeFunction")));
        if ((request.getParameter("nameFunction") != null)&&(!request.getParameter("nameFunction").equals("")))
            functionDevicesEntity.setNameFunction((request.getParameter("nameFunction")));
        if ((request.getParameter("data") != null)&&(!request.getParameter("data").equals("")))
            functionDevicesEntity.setData(Long.valueOf(request.getParameter("data")));
        if ((request.getParameter("minData") != null)&&(!request.getParameter("minData").equals("")))
            functionDevicesEntity.setMinData(Long.valueOf(request.getParameter("minData")));
        if ((request.getParameter("maxData") != null)&&(!request.getParameter("maxData").equals("")))
            functionDevicesEntity.setMaxData(Long.valueOf(request.getParameter("maxData")));
        if ((request.getParameter("description") != null)&&(!request.getParameter("description").equals("")))
            functionDevicesEntity.setDescription((request.getParameter("description")));
    }
    public FunctionDevicesEntity build() {
        return functionDevicesEntity;
    }
}
