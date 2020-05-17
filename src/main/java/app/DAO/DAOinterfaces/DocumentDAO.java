package app.DAO.DAOinterfaces;

import app.entityes.DocumentTypeEntity;
import app.entityes.DocumentsClientEntity;

import java.util.Collection;

public interface DocumentDAO extends DAOMain<DocumentsClientEntity> {

    public DocumentsClientEntity getDocumentById(int idDocument);
    public Collection<DocumentTypeEntity> getAllDocumentType(int limit, int offset);
}
