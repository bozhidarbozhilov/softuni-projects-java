package metube_v2.service;

import metube_v2.domain.entities.User;
import metube_v2.domain.models.service.UserServiceModel;
import metube_v2.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        User user = this.mapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));
        this.userRepository.save(user);
        return true;
    }

    @Override
    public UserServiceModel findUserByName(String name) {
        User user = this.userRepository.findByUsername(name);

        return this.mapper.map(user,UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserById(String id) {
        User user = this.userRepository.findById(id);

        return mapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {

        return this.userRepository.getAll().stream()
                .map(user -> mapper.map(user, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        User foundUser = this.userRepository.findByUsername(userServiceModel.getUsername());

        if(foundUser == null){
            return false;
        }
        return foundUser.getPassword().equals(DigestUtils.sha256Hex(userServiceModel.getPassword()));
    }

    @Override
    public void updateUser(UserServiceModel userServiceModel) {
        User user = mapper.map(userServiceModel, User.class);
        userRepository.update(user);
    }
}
