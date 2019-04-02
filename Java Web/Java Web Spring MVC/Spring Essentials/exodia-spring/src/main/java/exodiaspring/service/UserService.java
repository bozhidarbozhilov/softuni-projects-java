package exodiaspring.service;


import exodiaspring.domain.models.service.UserServiceModel;

public interface UserService {
    UserServiceModel saveUser(UserServiceModel userServiceModel);

    UserServiceModel findUserById(String id);

    UserServiceModel findUserByUsername(String username);

    UserServiceModel loginUser(UserServiceModel userServiceModel);
}
