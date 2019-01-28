package app.services.api;

import app.models.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface UserService {
    User getUsersDetails(Long id);
    void saveUser(User user);
    List<User> getAllUsers();
    List<User> getAllByEmailEndingWith(String emailProvider);
    void setDeletedStatusToInactiveUsersAfter(@Param("date") LocalDateTime date);
    int deleteAllByDeleted(boolean isDeleted);

}
