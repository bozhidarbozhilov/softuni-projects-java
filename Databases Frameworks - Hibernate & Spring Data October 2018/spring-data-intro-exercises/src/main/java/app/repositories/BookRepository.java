package app.repositories;

import app.enumerations.AgeRestriction;
import app.enumerations.EditionType;
import app.models.Author;
import app.models.Book;
import app.models.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getAllByReleaseDateAfter(LocalDate date);
    List<Book> getAllByAuthorOrderByReleaseDateAscTitleDesc(Author author);
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int numOfCopies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal upperPrice);

    @Query(value = "select b from Book b where function('YEAR', b.releaseDate) <> :year")
    List<Book> findAllByReleaseDateNot(@Param(value = "year")Integer year);

    @Query(value ="select b from Book b where b.releaseDate < :beforeDate")
    List<Book> findAllBooksReleasedBeforeDate(@Param(value="beforeDate") LocalDate beforeDate);

    @Query(value="select b from Book b where b.title like concat('%',:containString,'%') ")
    List<Book> findAllByTitleContainGivenString(@Param(value="containString") String containString);

    @Query(value="select b from Book b join b.author a where a.lastName like concat(:startString, '%')")
    List<Book> findAllByAuthorLastNameStartsWith(@Param("startString") String startString);

    @Query(value="select count(b.id) from Book b where length(b.title) > :minLength ")
    Integer countByTitleGreaterThan(@Param("minLength") int minLength);

    @Query(value="select concat(b.author.firstName,' ', b.author.lastName), sum(b.copies) as sumOfCopies " +
            "from Book b group by b.author.id " +
            "order by sum(b.copies) desc")
    List<Object[]> countAllBookCopiesByAuthor();

    @Query(value="select new app.models.ReducedBook(b.title, b.editionType, b.ageRestriction, b.price) " +
            "from Book b where b.title = :title ")
    ReducedBook getReducedBookInformationForGivenTitle(@Param(value = "title") String title);

    @Modifying
    @Transactional
    @Query(value="update Book b set b.copies = b.copies + :increaseNumber " +
            "where b.releaseDate> :releaseDate")
    int increaseBookCopiesAfterGivenReleaseDate(@Param(value = "increaseNumber") int increaseNumber,
                                                 @Param(value = "releaseDate") LocalDate releaseDate);

    @Modifying
    int removeBooksByCopiesLessThan(Integer lessThan);

}
