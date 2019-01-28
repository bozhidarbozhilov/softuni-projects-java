package app.repositories;

import app.models.Town;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByEmailEndingWith(String emailProvider);
    List<User> getAllByBornTown(Town town);
    List<User> findByFriendsToUser(User user);
    @Modifying(clearAutomatically = true)
    @Query("update User u set u.deleted = true where u.registrationDate>:date")
    void setDeletedStatusToInactiveUsersAfter(@Param("date") LocalDateTime date);
    int deleteAllByDeleted(boolean isDeleted);

}
