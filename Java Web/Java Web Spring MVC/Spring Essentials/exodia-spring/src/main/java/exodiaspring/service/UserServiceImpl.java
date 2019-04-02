package exodiaspring.service;

import exodiaspring.domain.entities.User;
import exodiaspring.domain.models.service.UserServiceModel;
import exodiaspring.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserServiceModel saveUser(UserServiceModel userServiceModel) {

        User user = this.mapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));
        User savedUser = this.userRepository.saveAndFlush(user);

        return this.mapper.map(savedUser, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserById(String id) {
        return this.mapper.map(this.userRepository.findById(id), UserServiceModel.class);
    }


    @Override
    public UserServiceModel findUserByUsername(String username) {
        return this.mapper.map(this.userRepository.findByUsername(username), UserServiceModel.class);
    }


    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        User user = this.userRepository.findByUsername(userServiceModel.getUsername());

        if(user==null || !user.getPassword().equals(DigestUtils.sha256Hex(userServiceModel.getPassword()))){
            return null;
        }
        return mapper.map(user, UserServiceModel.class);
    }
}
