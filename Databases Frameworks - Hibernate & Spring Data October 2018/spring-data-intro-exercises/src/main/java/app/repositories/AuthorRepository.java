package app.repositories;

import app.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> getAllByBooksBefore(LocalDate date);

    /*    @Query("select a.firstName, a.lastName, count(b.id) as books_count " +
                "from Author a join Book b on b.author_id = a.id " +
                "group by a.books " +
                "order by books_count desc ")*/
    List<Author> countAuthorsByBooks(Set<Author> authors);

    List<Author> findAllByFirstNameEndsWith(String endString);
    @Query(value="select concat(a.firstName,' ', a.lastName,' - ',sum(b.copies)) " +
            "from Author a join a.books b group by a.id order by sum(b.copies) desc ")
    List<Object> getAuthorsCopiesNumber();

    @Procedure(procedureName = "udp_authors_books_published")
    Integer getAuthorsBooksCount(@Param(value = "first_name") String firstName,
                                 @Param(value = "last_name") String lastName);

}
