package app.controllers;

import app.builder.DocumentBuilder;
import app.entityes.DocumentTypeEntity;
import app.entityes.DocumentsClientEntity;
import app.services.DocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addDocument","/delDocument","/updDocument","/viewDocument"})
public class DocumentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        DocumentService documentService = new DocumentService();
        if(request.getServletPath().equals("/addDocument")) {
            if(request.getParameter("client") == null) {//get/post заполнение id
                request.setAttribute("client", request.getParameter("idClient"));
            }
            List<DocumentTypeEntity> documentTypeEntityList = (List<DocumentTypeEntity>) documentService.getDocumentType(0,0);
            request.setAttribute("documentTypeEntityList", documentTypeEntityList);
            requestDispatcher = request.getRequestDispatcher("view/addDocument.jsp");
        }else { //вывод отпеделённого док. или его обновление
            DocumentsClientEntity documentsClientEntity = documentService.getDocumentById(Integer.parseInt(request.getParameter("idDocument")));//получение определённого документа из бд
            request.setAttribute("documentClient", documentsClientEntity);
            List<DocumentTypeEntity> documentTypeEntityList = (List<DocumentTypeEntity>) documentService.getDocumentType(0,0);
            request.setAttribute("documentTypeEntityList", documentTypeEntityList);
            requestDispatcher = request.getRequestDispatcher("view/viewDocument.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        DocumentService documentService = new DocumentService();
        DocumentsClientEntity documentsClientEntity = null;
        try {
            documentsClientEntity = new DocumentBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(request.getServletPath().equals("/addDocument")) {
            if (documentService.addDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentAdded", "true");
                request.setAttribute("client", request.getParameter("client"));
            }
            else request.setAttribute("isDocumentAdded", "false");
            doGet(request, response);
        }

        if(request.getServletPath().equals("/updDocument")) {
            if (documentService.updDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentUpd", "true");
            }
            else {
                request.setAttribute("isDocumentUpd", "false");
            }
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delDocument")) {
            if (documentService.delDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isDocumentdel", "false");
                doGet(request, response);
            }
        }
    }
}


