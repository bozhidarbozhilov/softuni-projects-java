package app.services.implementations;

import app.models.dto.bindingModels.CreateProductDto;
import app.models.dto.NoBuyerProductsDto;
import app.models.dto.SoldProductDto;
import app.models.dto.xmlProcessing.query1.ProductsInRangeRootDto;
import app.models.dto.xmlProcessing.query2.SoldProductRootDto;
import app.models.entities.Category;
import app.models.entities.Product;
import app.models.entities.User;
import app.repositories.CategoryRepository;
import app.repositories.ProductRepository;
import app.repositories.UserRepository;
import app.services.interfaces.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              UserRepository userRepository,
                              CategoryRepository categoryRepository,
                              ModelMapper mapper) {
        this.productRepository = productRepository;
        this.userRepository= userRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public void createProduct(CreateProductDto productDto) {
        Validator validator = Validation.byDefaultProvider().
                configure().buildValidatorFactory().getValidator();

        if(validator.validate(productDto).size()>0){
            for(ConstraintViolation<CreateProductDto> violation: validator.validate(productDto)) {
                throw new IllegalArgumentException(violation.getMessage());
            }
        }else{
            Product product = mapper.map(productDto,Product.class);
            List<User> allUsers = this.userRepository.findAll();
            product.setSeller(allUsers.get(new Random().nextInt(allUsers.size())));
            int randomNumber = new Random().nextInt(allUsers.size());
            if (randomNumber % 5 == 0) {
                product.setBuyer(null);
            } else {
                product.setBuyer(allUsers.get(randomNumber));
            }
            List<Category> allCategories = this.categoryRepository.findAll();
            Set<Category> setCategories = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                int rand = new Random().nextInt(allCategories.size());
                if(rand>0){
                    setCategories.add(allCategories.get(rand));
                }else {
                    i--;
                }

            }
            product.setCategories(setCategories);
            this.productRepository.saveAndFlush(product);
        }
    }

    @Override
    public void createAll(List<CreateProductDto> createProductDtos) {
        createProductDtos.forEach(this::createProduct);
    }

    @Override
    public List<NoBuyerProductsDto> productsWithNoBuyersByPriceRange() {
        return this.productRepository.getProductsWithNoBuyer().stream()
                .map(product -> mapper.map(product, NoBuyerProductsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductsInRangeRootDto exportProductsInRangeToXml(List<NoBuyerProductsDto> noBuyerProductsDtos) {
        ProductsInRangeRootDto productsInRangeRootDto = new ProductsInRangeRootDto();
        productsInRangeRootDto.setProductsInRangeDtoList(noBuyerProductsDtos);
        return productsInRangeRootDto;
    }

    @Override
    public SoldProductRootDto createSoldProductRootDto(Set<Product> products) {
        SoldProductRootDto soldProductRootDto = new SoldProductRootDto();

        soldProductRootDto.setSoldProductDtos(products.stream().
                map(product -> mapper.map(product, SoldProductDto.class)).collect(Collectors.toSet()));

        return soldProductRootDto;
    }


}
