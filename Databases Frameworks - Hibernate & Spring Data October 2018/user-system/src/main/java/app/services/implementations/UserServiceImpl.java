package app.services.implementations;

import app.models.User;
import app.repositories.UserRepository;
import app.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUsersDetails(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> getAllByEmailEndingWith(String emailProvider) {
        return this.userRepository.getAllByEmailEndingWith(emailProvider);
    }

    @Override
    public void setDeletedStatusToInactiveUsersAfter(LocalDateTime enteredDate) {
        this.userRepository.setDeletedStatusToInactiveUsersAfter(enteredDate);
    }

    @Override
    public int deleteAllByDeleted(boolean isDeleted) {
        return this.userRepository.deleteAllByDeleted(isDeleted);
    }
}
