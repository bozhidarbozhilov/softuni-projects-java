package app.controller;

import app.enumerations.AgeRestriction;
import app.enumerations.EditionType;
import app.models.Author;
import app.models.Book;
import app.models.Category;
import app.services.interfaces.AuthorService;
import app.services.interfaces.BookService;
import app.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class BookShopController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;
    private Scanner scanner;

    @Autowired
    public BookShopController(AuthorService authorService,
                              CategoryService categoryService,
                              BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        //seedDatabase();
        //-----Problem 1
/*        this.bookService.getAllBooksByAgeRestrictions(AgeRestriction.valueOf("teEN".toUpperCase()))
                .forEach(book -> System.out.println(book.getTitle()));*/

        //-----Problem 2
/*        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(book -> System.out.println(book.getTitle()));*/

        //-----Problem 3
/*        this.bookService.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.printf("%s - $%s%n", book.getTitle(), book.getPrice()));*/

/*        //-----Problem 4
        this.bookService.findAllByReleaseDateNot(1998)
                .forEach(book -> System.out.println(book.getTitle()));*/

        //-----Problem 5
/*        System.out.print("Enter date before which the books are released: ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate beforeDate = LocalDate.parse(scanner.nextLine(),dtf);
        System.out.println(this.bookService.getAllBooksReleasedBeforeGivenDate(beforeDate));*/

        //-----Problem 6
/*        System.out.print("Enter desired string for end of author first name: ");
        System.out.println(this.authorService.getAuthorsByFirstNameEndsWith(scanner.nextLine()));*/


/*        //-----Problem 7
        System.out.print("Enter desired string contains in book title: ");
        System.out.println(this.bookService.getAllBooksContainingGivenString(scanner.nextLine()));*/

        //-----Problem 8
/*        System.out.print("Enter desired string for start of author's last name: ");
        System.out.println(this.bookService.getAllByAuthorLastNameStartsWith(scanner.nextLine()));*/

        //-----Problem 9
/*        System.out.print("Enter desired min length: ");
        System.out.println(this.bookService.countTitlesLongerThanGivenLength(Integer.parseInt(scanner.nextLine())));*/

        //-----Problem 10
        //System.out.println(this.bookService.getBookCopiesNumberByAuthors());
        //System.out.println(this.authorService.getAuthorsCopiesNumber());

        //-----Problem 11
        //System.out.print("Enter book title: ");
        //System.out.println(this.bookService.getReducedBookInformationByTitle("Thrones"));

        //-----Problem 12
/*        System.out.print("Enter problem arguments: ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), dtf);
        int increaseNumber = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.increaseBookCopiesAfterReleaseDateBy(increaseNumber, releaseDate)
                * increaseNumber);*/

        //-----Problem 13
        //System.out.println(this.bookService.deleteBooksWithCopiesLessThan(4200) + " books were deleted.");

        //----Problem 14
        System.out.print("Enter author name: ");
        String[] fullName = scanner.nextLine().trim().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];
        Integer result = this.authorService.getAuthorsPublishedBooksCount(firstName, lastName);
        if(result != 0){
            System.out.printf("%s %s has written %d books%n",firstName, lastName,result);
        }else{
            System.out.printf("%s %s has not written any books yet.%n",firstName, lastName);
        }

    }
    private void seedDatabase() throws IOException {
        seedCategories();
        seedAuthors();
        seedBooks();
    }

    private void seedCategories() throws IOException {
        BufferedReader categoriesReader =
                new BufferedReader(new FileReader("src\\main\\files\\categories.txt"));
        String line = "";

        while((line=categoriesReader.readLine()) != null){
            Category category = new Category();
            String[] token = line.split("\\s+");
            if(!token[0].isEmpty()){
                category.setName(token[0]);
                this.categoryService.save(category);
            }

        }
    }


    private void seedAuthors() throws IOException {
        BufferedReader authorsReader = new BufferedReader(new FileReader("src\\main\\files\\authors.txt"));
        String line ="";

        while((line=authorsReader.readLine())!=null){
            String[] tokens = line.split("\\s+");

            String firstName = "";
            String lastName = "";
            Author author = new Author();
            if(tokens.length>1){
                firstName = tokens[0];
                lastName = tokens[1];
            }else{
                lastName = tokens[0];
            }
            if(firstName != null){
                author.setFirstName(firstName);
            }
            author.setLastName(lastName);
            this.authorService.save(author);
        }

    }
    private void seedBooks() throws IOException {
        BufferedReader booksReader = new BufferedReader(new FileReader("src\\main\\files\\books.txt"));
        String line = "";
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");


            //Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(data[1],formatter);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(getRandomAuthor());
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            Set<Category> randomCategories = getRandomCategories();
            book.setCategories(randomCategories);
            this.bookService.persistBook(book);
        }
    }

    private Set<Category> getRandomCategories() {
        int categoriesSize = this.categoryService.getAllCategories().size();

        List<Category> categories = this.categoryService.getAllCategories();
        Set<Category> categoriesSet = new HashSet<>();
        int randomCategoriesSize = new Random().nextInt(5);

        for (int i = 0; i < randomCategoriesSize; i++) {
           int randomCategoryNumber =
                    new Random().nextInt(categoriesSize);
            categoriesSet.add(categories.get(randomCategoryNumber));
        }
        return categoriesSet;
    }

    private Author getRandomAuthor() {
        long randomIndex =  new Random().nextInt(this.authorService.getAllAuthors().size())+1;
        Author author = this.authorService.getAuthorById(randomIndex).orElse(null);

        return author;
    }
}
