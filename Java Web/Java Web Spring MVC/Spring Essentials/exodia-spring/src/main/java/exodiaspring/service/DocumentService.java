package exodiaspring.service;

import exodiaspring.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    DocumentServiceModel saveDocument(DocumentServiceModel documentServiceModel);

    List<DocumentServiceModel> findAllDocuments();

    DocumentServiceModel findDocumentById(String id);

    void printDocument(String id);
}
