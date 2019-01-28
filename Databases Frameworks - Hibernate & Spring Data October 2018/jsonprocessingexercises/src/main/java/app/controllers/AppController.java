package app.controllers;

import app.models.dto.Query4Dto;
import app.models.dto.bindingModels.CreateCategoryDto;
import app.models.dto.bindingModels.CreateProductDto;
import app.models.dto.bindingModels.CreateUserDto;
import app.models.dto.xmlProcessing.query2.UserSoldProductsRootXmlDto;
import app.models.dto.xmlProcessing.query3.CategoryByProductsRootDto;
import app.services.interfaces.CategoryService;
import app.services.interfaces.ProductService;
import app.services.interfaces.UserService;
import app.utils.FileUtil;
import app.utils.JsonParser;
import app.utils.XmlParserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AppController implements CommandLineRunner {
    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private FileUtil fileUtil;
    private JsonParser jsonParser;
    private XmlParserImpl xmlParser;

    @Autowired
    public AppController(UserService userService, ProductService productService,
                         CategoryService categoryService,
                         FileUtil fileUtil, JsonParser jsonParser, XmlParserImpl xmlParser) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileUtil = fileUtil;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
/*        seedUsers();
        seedCategories();
        seedProducts();*/


/*        List<NoBuyerProductsDto> dtoList = this.productService.productsWithNoBuyersByPriceRange();
        String exportToFile =
                this.jsonParser.exportToFile(dtoList);
        this.fileUtil.writeToFile(exportToFile, "src\\main\\resources\\files\\noBuyerProducts.json");*/

/*        List<UserSoldProductsDto> soldProducts =
                this.userService.getUsersSoldProducts();
        String exportSoldProductsToFile = this.jsonParser.exportToFile(soldProducts);
        this.fileUtil.writeToFile(exportSoldProductsToFile,
                "src\\main\\resources\\files\\users-sold-product.json");*/

/*        String categoriesByProductCountAndTotalPrice = this.jsonParser
                .exportToFile(this.categoryService.getCategoriesByProductsCount());
        this.fileUtil.writeToFile(categoriesByProductCountAndTotalPrice,
                "src\\main\\resources\\files\\categories-by-products.json");*/
/*        String query4String = this.jsonParser.exportToFile(this.userService.getUsersSoldProductsAndCount());
        this.fileUtil.writeToFile(query4String, "src\\main\\resources\\files\\users-and-products.json");*/

        //--------------------------------Xml Processing----------------------------------
/*        String productsInRangeFilePath = "F:\\SoftUni Main\\Databases\\Databases Advanced - Hibernate\\" +
                "10. JSON Processing\\Exercises\\jsonprocessingexercises" +
                "\\src\\main\\resources\\files\\xmlProcessing\\products-in-range.xml";
        ProductsInRangeRootDto productsInRangeRootDto =
                this.productService.
                        exportProductsInRangeToXml(this.productService.
                                productsWithNoBuyersByPriceRange());*/

        //this.xmlParser.marshallXml(productsInRangeRootDto.getClass(), productsInRangeRootDto, productsInRangeFilePath);

/*        String usersSoldProductsFilePath = "F:\\SoftUni Main\\Databases\\Databases Advanced - Hibernate\\10. JSON Processing\\Exercises\\jsonprocessingexercises" +
                "\\src\\main\\resources\\files\\xmlProcessing\\users-sold-products.xml";

        UserSoldProductsRootXmlDto userSoldProductsRootXmlDto = this.userService.exportUserSoldProductsToXml();

        this.xmlParser.marshallXml(userSoldProductsRootXmlDto, UserSoldProductsRootXmlDto.class,
                usersSoldProductsFilePath);*/
/*        String categoryByProductsFilePath = "F:\\SoftUni Main\\Databases\\Databases Advanced - Hibernate" +
                "\\10. JSON Processing\\Exercises\\jsonprocessingexercises\\src\\main" +
                "\\resources\\files\\xmlProcessing\\categories-by-products.xml";
        CategoryByProductsRootDto exportCategoriesByProducts = this.categoryService.exportCategoriesProducts();
        this.xmlParser.marshallXml(exportCategoriesByProducts,CategoryByProductsRootDto.class,
                categoryByProductsFilePath);*/
        String usersAndProductsFilePath = "F:\\SoftUni Main\\Databases\\Databases Advanced - Hibernate" +
                "\\10. JSON Processing\\Exercises\\jsonprocessingexercises\\src\\main" +
                "\\resources\\files\\xmlProcessing\\users-and-products.xml";
        Query4Dto query4Dto = this.userService.getUsersSoldProductsAndCount();
        this.xmlParser.marshallXml(query4Dto,Query4Dto.class,usersAndProductsFilePath);
    }

    private void seedProducts() throws FileNotFoundException {
        String productFile = fileUtil.readFromFile("src\\main\\resources\\files\\products.json");
        List<CreateProductDto> createProductDtos = Arrays.
                asList(jsonParser.importFromFile(CreateProductDto[].class,productFile));
        this.productService.createAll(createProductDtos);
    }

    private void seedCategories() throws FileNotFoundException {
        String categoryFile = fileUtil.readFromFile("src\\main\\resources\\files\\categories.json");
        List<CreateCategoryDto> createCategoryDtos =
                Arrays.asList(jsonParser.importFromFile(CreateCategoryDto[].class, categoryFile));
        this.categoryService.createAllCategories(createCategoryDtos);
    }

    private void seedUsers() throws FileNotFoundException {
        String userFile = fileUtil.readFromFile("src\\main\\resources\\files\\users.json");
        List<CreateUserDto> createUserDtos = Arrays.asList(jsonParser.importFromFile(CreateUserDto[].class,
                userFile));
        this.userService.createAll(createUserDtos);
    }

    private long getRandomUserId(int limit) {
        return (long) new Random().nextInt(limit);
    }
}
