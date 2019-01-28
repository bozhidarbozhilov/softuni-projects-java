package app.services.interfaces;

import app.models.dto.bindingModels.CreateUserDto;
import app.models.dto.Query4Dto;
import app.models.dto.UserSoldProductsDto;
import app.models.dto.xmlProcessing.query2.UserSoldProductXmlDto;
import app.models.dto.xmlProcessing.query2.UserSoldProductsRootXmlDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void createUser(CreateUserDto userDto);
    void createAll(List<CreateUserDto> createUserDtos);
    List<UserSoldProductsDto> getUsersSoldProducts();
    Query4Dto getUsersSoldProductsAndCount();
    List<UserSoldProductXmlDto> getUsersSoldProductsForXml();
    UserSoldProductsRootXmlDto exportUserSoldProductsToXml();

}
