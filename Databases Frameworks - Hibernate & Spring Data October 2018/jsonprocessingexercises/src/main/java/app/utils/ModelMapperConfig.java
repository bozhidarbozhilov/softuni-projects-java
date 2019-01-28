package app.utils;

import app.models.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        //CreateProductDto.configureMap(mapper);
        //NoBuyerProductsDto.configureMapping(mapper);
        SoldProductDto.configureMapping(mapper);
        Query4UsersDto.configureMapping(mapper);

        mapper.validate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }
}
