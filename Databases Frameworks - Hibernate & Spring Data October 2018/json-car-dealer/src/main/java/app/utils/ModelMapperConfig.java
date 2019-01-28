package app.utils;

import app.models.dtos.view.LocalSupplierDto;
import app.models.dtos.view.OrderedCustomersDto;
import app.models.dtos.view.SalesDiscountDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        LocalSupplierDto.configureMapping(mapper);
        mapper.validate();
    }

    @Bean
    public static ModelMapper modelMapper(){
        return mapper;
    }
}
