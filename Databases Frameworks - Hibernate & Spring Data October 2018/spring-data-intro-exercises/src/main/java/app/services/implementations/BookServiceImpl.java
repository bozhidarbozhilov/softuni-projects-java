package app.services.implementations;

import app.enumerations.AgeRestriction;
import app.enumerations.EditionType;
import app.models.Author;
import app.models.Book;
import app.models.ReducedBook;
import app.repositories.BookRepository;
import app.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public void persistBook(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAllBooksByAgeRestrictions(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int numOfCopies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, numOfCopies);
    }

    @Override
    public List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal upperPrice) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowerPrice, upperPrice);
    }

    @Override
    public List<Book> findAllByReleaseDateNot(Integer year) {
        return this.bookRepository.findAllByReleaseDateNot(year);
    }

    @Override
    public String getAllBooksReleasedBeforeGivenDate(LocalDate beforeDate) {
        StringBuilder result = new StringBuilder();
        this.bookRepository.findAllBooksReleasedBeforeDate(beforeDate)
                .forEach(book -> result.append(String.format("%s %s - $%s%n",
                        book.getTitle(), book.getEditionType(), book.getPrice())));
        return result.toString();
    }

    @Override
    public String getAllBooksContainingGivenString(String containString) {
        StringBuilder result = new StringBuilder();
        this.bookRepository.findAllByTitleContainGivenString(containString)
                .forEach(book -> result.append(String.format("%s%n", book.getTitle())));
        return result.toString();
    }

    @Override
    public String getAllByAuthorLastNameStartsWith(String startString) {
        StringBuilder result = new StringBuilder();
        this.bookRepository.findAllByAuthorLastNameStartsWith(startString)
                .forEach(book -> result.append(String.format("%s (%s %s)%n", book.getTitle(),
                        book.getAuthor().getFirstName(), book.getAuthor().getLastName())));
        return result.toString();
    }

    @Override
    public int countTitlesLongerThanGivenLength(int minLength) {
        return this.bookRepository.countByTitleGreaterThan(minLength);
    }

    @Override
    public String getBookCopiesNumberByAuthors() {
         StringBuilder sb = new StringBuilder();
        for (Object[] book : this.bookRepository.countAllBookCopiesByAuthor()) {
            String author = (String) book[0];
            Long copies = (Long) book[1];
            sb.append(String.format("%s - %d",
                    author,
                    copies))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String getReducedBookInformationByTitle(String title) {
        ReducedBook reducedBook = this.bookRepository.getReducedBookInformationForGivenTitle(title);
        return reducedBook.getTitle() +" "+reducedBook.getEditionType()+" "+reducedBook.getAgeRestriction()
                +" $"+reducedBook.getPrice();
    }

    @Override
    public int increaseBookCopiesAfterReleaseDateBy(int increaseNumber, LocalDate releaseDate) {
        return this.bookRepository.increaseBookCopiesAfterGivenReleaseDate(increaseNumber, releaseDate);
    }

    @Override
    public int deleteBooksWithCopiesLessThan(Integer lessThan) {
        return this.bookRepository.removeBooksByCopiesLessThan(lessThan);
    }

}
