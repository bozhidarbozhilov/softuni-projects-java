package com.bozhilov.boocarep.service.user;

import com.bozhilov.boocarep.domain.entities.users.User;
import com.bozhilov.boocarep.domain.models.service.UserServiceModel;
import com.bozhilov.boocarep.repository.UserRepository;
import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.io.InvalidObjectException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bozhilov.boocarep.utils.Constants.INVALID_USERS_PROPERTIES;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Validator validator) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public UserServiceModel saveUser(UserServiceModel userServiceModel) throws InvalidObjectException {
        if(validator.validate(userServiceModel).size()>0){
            throw new InvalidObjectException(INVALID_USERS_PROPERTIES);
        }
        User savedUser = this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        return this.modelMapper.map(savedUser, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return this.userRepository.findAll().stream()
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        User foundUser = this.userRepository.findByUsername(username);
        if(foundUser == null){
            return null;
        }
        return this.modelMapper.map(foundUser, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByEmail(String email) {
        User foundUser = this.userRepository.findByEmail(email);
        if(foundUser == null){
            return null;
        }

        return this.modelMapper.map(foundUser, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByPhoneNumber(String phoneNumber) {
        User foundUser = this.userRepository.findByPhoneNumber(phoneNumber);
        if(foundUser == null){
            return null;
        }
        return this.modelMapper.map(foundUser, UserServiceModel.class);
    }
}
