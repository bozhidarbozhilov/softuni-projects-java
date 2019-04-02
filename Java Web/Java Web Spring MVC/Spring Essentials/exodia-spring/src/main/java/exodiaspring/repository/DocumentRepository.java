package exodiaspring.repository;

import exodiaspring.domain.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
}
