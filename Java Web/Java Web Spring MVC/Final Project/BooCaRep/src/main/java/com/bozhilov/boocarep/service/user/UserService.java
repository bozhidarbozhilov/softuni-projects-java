package com.bozhilov.boocarep.service.user;

import com.bozhilov.boocarep.domain.models.service.UserServiceModel;

import java.io.InvalidObjectException;
import java.util.List;

public interface UserService {
    UserServiceModel saveUser(UserServiceModel userServiceModel) throws InvalidObjectException;
    List<UserServiceModel> findAllUsers();
    UserServiceModel findUserByUsername(String username);
    UserServiceModel findUserByEmail(String email);
    UserServiceModel findUserByPhoneNumber(String phoneNumber);

}
