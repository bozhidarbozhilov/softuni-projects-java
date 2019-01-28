package app;

import app.models.User;
import app.services.api.TownService;
import app.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SpringBootApplication
@Controller
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final TownService townService;

    @Autowired
    public ConsoleRunner(UserService userService, TownService townService) {
        this.userService = userService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
        //addUsers(50);
/*        this.userService.getAllByEmailEndingWith("gmail.com")
                .forEach(user -> System.out.println(user.getUsername()+" "+ user.getEmail()));*/
        Scanner scanner = new Scanner(System.in);
/*        System.out.print("Enter date after from which you want to delete users: ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm:ss");
        LocalDateTime enteredDate = LocalDateTime.parse(scanner.nextLine()+" 00:01:00", dtf);
        this.userService.setDeletedStatusToInactiveUsersAfter(enteredDate);*/
        int affectedRows = this.userService.deleteAllByDeleted(true);

    }
    private void addUsers(final int count) {
        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("pasSword%" + i);
            user.setEmail("mail" + i + "x@abv.bg");
            user.setAge(i % 120 + 1);
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            user.setRegistrationDate(LocalDateTime.now());
            user.setLastTimeLoggedIn(LocalDateTime.now());
            user.setDeleted(false);
            this.userService.saveUser(user);
        }
    }
}
