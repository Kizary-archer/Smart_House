package app.builder;

import app.entityes.DocumentsClientEntity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public final class DocumentBuilder  {
    DocumentsClientEntity documentsClientEntity = new DocumentsClientEntity();

    public DocumentBuilder(HttpServletRequest request) throws Exception{
        if (request.getParameter("idDocument") != null)
            if(!request.getParameter("idDocument").equals(""))
                documentsClientEntity.setIdDocument(Integer.parseInt(request.getParameter("idDocument")));
        if (request.getParameter("series") != null)
            if(!request.getParameter("series").equals(""))
                documentsClientEntity.setSeries(Integer.parseInt(request.getParameter("series")));
        if (request.getParameter("number") != null)
            if(!request.getParameter("number").equals(""))
                documentsClientEntity.setNumber(Integer.parseInt(request.getParameter("number")));
        if (request.getParameter("issued") != null)
            if (!request.getParameter("issued").equals(""))
                documentsClientEntity.setIssued(request.getParameter("issued"));
        if (request.getParameter("dateOfIssue") != null)
            if (!request.getParameter("dateOfIssue").equals(""))
                documentsClientEntity.setDateOfIssue(Date.valueOf(request.getParameter("dateOfIssue")));
        if (request.getParameter("typeDocument") != null)
            if(!request.getParameter("typeDocument").equals(""))
                documentsClientEntity.setTypeDocument(Integer.parseInt(request.getParameter("typeDocument")));
        if (request.getParameter("client") != null)
            if(!request.getParameter("client").equals(""))
                documentsClientEntity.setClient(Integer.parseInt(request.getParameter("client")));

    }
    public DocumentsClientEntity build() {
        return documentsClientEntity;
    }
}
