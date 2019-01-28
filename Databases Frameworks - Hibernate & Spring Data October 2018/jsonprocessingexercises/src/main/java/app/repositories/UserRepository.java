package app.repositories;

import app.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u from User u join u.soldProducts p " +
            "where p.buyer is not null " +
            "group by u.id " +
            "order by u.lastName, u.firstName")
    List<User> getAllUsersWithSoldProduct();
}
