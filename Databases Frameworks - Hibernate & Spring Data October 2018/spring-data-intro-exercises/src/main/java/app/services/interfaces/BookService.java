package app.services.interfaces;

import app.enumerations.AgeRestriction;
import app.enumerations.EditionType;
import app.models.Book;
import org.springframework.data.repository.query.Param;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void persistBook(Book book);
    List<Book> getAllBooksByAgeRestrictions(AgeRestriction ageRestriction);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int numOfCopies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal upperPrice);
    List<Book> findAllByReleaseDateNot(Integer year);
    String getAllBooksReleasedBeforeGivenDate(LocalDate beforeDate);
    String getAllBooksContainingGivenString(String containString);
    String getAllByAuthorLastNameStartsWith(String startString);
    int countTitlesLongerThanGivenLength(int minLength);
    String getBookCopiesNumberByAuthors();
    String getReducedBookInformationByTitle(String title);
    int increaseBookCopiesAfterReleaseDateBy(int increaseNumber, LocalDate releaseDate);
    int deleteBooksWithCopiesLessThan(Integer lessThan);

}
