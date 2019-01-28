package app.services.implementations;

import app.models.dto.*;
import app.models.dto.bindingModels.CreateUserDto;
import app.models.dto.xmlProcessing.query2.SoldProductRootDto;
import app.models.dto.xmlProcessing.query2.UserSoldProductXmlDto;
import app.models.dto.xmlProcessing.query2.UserSoldProductsRootXmlDto;
import app.models.entities.User;
import app.repositories.ProductRepository;
import app.repositories.UserRepository;
import app.services.interfaces.ProductService;
import app.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private ModelMapper mapper;
    private final ProductService productService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ProductRepository productRepository,
                           ModelMapper mapper, ProductService productService) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.productService = productService;
    }

    @Override
    public void createUser(CreateUserDto userDto) {
        Validator validator = Validation.byDefaultProvider().
                configure().buildValidatorFactory().getValidator();

        if(validator.validate(userDto).size()>0){
            for(ConstraintViolation<CreateUserDto> violation: validator.validate(userDto)) {
                throw new IllegalArgumentException(violation.getMessage());
            }
        }else{
            User user=mapper.map(userDto, User.class);
            this.userRepository.save(user);
        }
    }

    @Override
    public void createAll(List<CreateUserDto> createUserDtos) {
        createUserDtos.forEach(this::createUser);
    }

    @Override
    public List<UserSoldProductsDto> getUsersSoldProducts() {

        return null;

    }

    @Override
    public Query4Dto getUsersSoldProductsAndCount() {
        List<User> users = this.userRepository.getAllUsersWithSoldProduct();
        List<Query4ProductDto> query4ProductDtos = new ArrayList<>();
        List<Query4UsersDto> query4UsersDtos = new ArrayList<>();

        for (User user : users) {
            query4ProductDtos = user.getSoldProducts()
                    .stream().filter(product -> product.getBuyer() != null)
                    .map(product -> mapper.map(product, Query4ProductDto.class))
                    .collect(Collectors.toList());

            Query4UsersDto query4UsersDto = new Query4UsersDto();
            query4UsersDto.setFirstName(user.getFirstName());
            query4UsersDto.setLastName(user.getLastName());
            query4UsersDto.setAge(user.getAge());

            Query4ProductsCountAndProductsDto query4ProductsCountAndProductsDto =
                    new Query4ProductsCountAndProductsDto();
            query4ProductsCountAndProductsDto.setProductsCount(query4ProductDtos.size());
            query4ProductsCountAndProductsDto.setProductDtos(query4ProductDtos);
            query4UsersDto.setSoldProducts(query4ProductsCountAndProductsDto);
            query4UsersDtos.add(query4UsersDto);
        }
        Query4Dto query4Dto = new Query4Dto(query4UsersDtos.size(), query4UsersDtos);
        return query4Dto;
    }

    @Override
    public List<UserSoldProductXmlDto> getUsersSoldProductsForXml() {
        List<User> users = this.userRepository.getAllUsersWithSoldProduct();
        List<UserSoldProductXmlDto> toReturn = new ArrayList<>();
        for (User user : users) {
            SoldProductRootDto soldProductRootDto = new SoldProductRootDto();
            soldProductRootDto.setSoldProductDtos(user.getSoldProducts().stream().map(product -> mapper.map(product, SoldProductDto.class))
                    .collect(Collectors.toSet()));

            UserSoldProductXmlDto userSoldProductXmlDto = mapper.map(user, UserSoldProductXmlDto.class);
            userSoldProductXmlDto.setSoldProducts(soldProductRootDto);
            toReturn.add(userSoldProductXmlDto);

        }
        return toReturn;
    }

    @Override
    public UserSoldProductsRootXmlDto exportUserSoldProductsToXml() {
        UserSoldProductsRootXmlDto userSoldProductsRootXmlDto = new UserSoldProductsRootXmlDto();
        userSoldProductsRootXmlDto.setUserSoldProductXmlDtos(this.getUsersSoldProductsForXml());
        return userSoldProductsRootXmlDto;
    }
}
