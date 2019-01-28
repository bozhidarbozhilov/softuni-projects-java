package app.models.dto;

import app.models.entities.User;
import org.modelmapper.ModelMapper;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Query4UsersDto {
    @XmlAttribute(name="first-name")
    private String firstName;
    @XmlAttribute(name="last-name")
    private String lastName;
    @XmlAttribute(name="age")
    private int age;
    @XmlElement(name="sold-products")
    private Query4ProductsCountAndProductsDto soldProducts;

    public Query4UsersDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Query4ProductsCountAndProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Query4ProductsCountAndProductsDto productsCountAndProductsDtos) {
        this.soldProducts = productsCountAndProductsDtos;
    }

    public static void configureMapping(ModelMapper mapper){
        mapper.createTypeMap(User.class,
                Query4UsersDto.class)
                .addMapping(User::getSoldProducts,
                        Query4UsersDto::setSoldProducts);
    }

}
