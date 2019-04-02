package exodiaspring.service;


import exodiaspring.domain.entities.Document;
import exodiaspring.domain.models.service.DocumentServiceModel;
import exodiaspring.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DocumentServiceModel saveDocument(DocumentServiceModel documentServiceModel) {
        Document document = this.modelMapper.map(documentServiceModel, Document.class);
        this.documentRepository.saveAndFlush(document);
        return this.modelMapper.map(document, DocumentServiceModel.class);
    }

    @Override
    public List<DocumentServiceModel> findAllDocuments() {
        return this.documentRepository.findAll().stream()
                .map(d->this.modelMapper.map(d, DocumentServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public DocumentServiceModel findDocumentById(String id) {
        return this.modelMapper.map(Objects.requireNonNull(this.documentRepository.findById(id).orElse(null)),
                DocumentServiceModel.class);
    }

    @Override
    public void printDocument(String id) {
        this.documentRepository.deleteById(id);
    }
}
