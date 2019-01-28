package app.services.implementations;

import app.models.Author;
import app.repositories.AuthorRepository;
import app.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public String getAuthorsByFirstNameEndsWith(String endString) {
        StringBuilder sb = new StringBuilder();
        this.authorRepository.findAllByFirstNameEndsWith(endString)
                .forEach(a->sb.append(String.format("%s %s%n", a.getFirstName(),a.getLastName())));
        return sb.toString();
    }

    @Override
    public String getAuthorsCopiesNumber() {
        return String.join(System.lineSeparator(),
                this.authorRepository.getAuthorsCopiesNumber()
                        .stream().map(o -> (String) o).collect(Collectors.toList()));
    }

    @Override
    public int getAuthorsPublishedBooksCount(String firstName, String lastName) {
        return this.authorRepository.getAuthorsBooksCount(firstName, lastName);
    }


}
