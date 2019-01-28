package app.models.dto;

import app.models.entities.Product;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoBuyerProductsDto {
    @XmlAttribute(name="name")
    private String name;
    @XmlAttribute(name="price")
    private BigDecimal price;
    @XmlAttribute(name="seller")
    private String seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String sellerName) {
        this.seller = sellerName;
    }

    public static void configureMapping(ModelMapper mapper){
        mapper.createTypeMap(Product.class, NoBuyerProductsDto.class)
                .addMapping(src->src.getSellerFullName(), NoBuyerProductsDto::setSeller);
    }



}
