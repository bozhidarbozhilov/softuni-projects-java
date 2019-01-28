package app.services.interfaces;

import app.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface AuthorService {
    void save(Author author);
    List<Author> getAllAuthors();
    Optional<Author> getAuthorById(Long id);
    String getAuthorsByFirstNameEndsWith(String endString);
    String getAuthorsCopiesNumber();
    int getAuthorsPublishedBooksCount(String firstName, String lastName);

}
