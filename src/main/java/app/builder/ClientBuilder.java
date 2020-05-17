package app.builder;

import app.entityes.ClientEntity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public final class ClientBuilder {
    ClientEntity clientEntity = new ClientEntity();

    public ClientBuilder (HttpServletRequest request) {
        if (request.getParameter("idClient") != null)
            if(!request.getParameter("idClient").equals(""))
                clientEntity.setIdClient(Integer.parseInt(request.getParameter("idClient")));
        if (request.getParameter("name") != null)
            if (!request.getParameter("name").equals(""))
                clientEntity.setName(request.getParameter("name"));
        if (request.getParameter("surname") != null)
            if (!request.getParameter("surname").equals(""))
                clientEntity.setSurname(request.getParameter("surname"));
        if (request.getParameter("patronymic") != null)
            if (!request.getParameter("patronymic").equals(""))
                clientEntity.setPatronymic(request.getParameter("patronymic"));
        if (request.getParameter("gender") != null)
            if (!request.getParameter("gender").equals(""))
                clientEntity.setGender(Boolean.valueOf(request.getParameter("gender")));
        if (request.getParameter("dateOfBirth") != null)
            if (!request.getParameter("dateOfBirth").equals(""))
                clientEntity.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
        if (request.getParameter("phoneNumber") != null)
            if (!request.getParameter("phoneNumber").equals(""))
                clientEntity.setPhoneNumber((request.getParameter("phoneNumber")));
        if (request.getParameter("email") != null)
            if (!request.getParameter("email").equals(""))
                clientEntity.setEmail((request.getParameter("email")));
    }
    public ClientEntity build() {
        return clientEntity;
    }
}
