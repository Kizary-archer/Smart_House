package app.services;

import app.DAO.DAOinterfaces.DocumentDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.*;

import java.util.Collection;

public class DocumentService {

    public boolean addDocument(DocumentsClientEntity documentsClientEntity){
        DocumentDAO documentDAO = DAOCreateFactoryUtil.getInstance().getDocumentDAO();
        return  documentDAO.add(documentsClientEntity);
    }
    public boolean delDocument(DocumentsClientEntity documentsClientEntity){
        DocumentDAO documentDAO = DAOCreateFactoryUtil.getInstance().getDocumentDAO();
        return  documentDAO.delete(documentsClientEntity);
    }
    public boolean updDocument(DocumentsClientEntity documentsClientEntity){
        DocumentDAO documentDAO = DAOCreateFactoryUtil.getInstance().getDocumentDAO();
        return  documentDAO.update(documentsClientEntity);
    }

    public DocumentsClientEntity getDocumentById(int idDocument){
        DocumentDAO  documentDAO = DAOCreateFactoryUtil.getInstance().getDocumentDAO();
        return  documentDAO.getDocumentById(idDocument);
    }

    public Collection<DocumentTypeEntity> getDocumentType(int limit,int offset){
        DocumentDAO  documentDAO = DAOCreateFactoryUtil.getInstance().getDocumentDAO();
        return  documentDAO.getAllDocumentType(limit,offset);
    }


}
