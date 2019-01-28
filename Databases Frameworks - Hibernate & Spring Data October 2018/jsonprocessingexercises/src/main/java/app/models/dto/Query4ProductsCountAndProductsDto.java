package app.models.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement(name="sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Query4ProductsCountAndProductsDto {
    @XmlAttribute(name="count")
    private int productsCount;
    @XmlElement(name="product")
    private List<Query4ProductDto> productDtos;

    public Query4ProductsCountAndProductsDto() {
        this.productDtos = new ArrayList<>();
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public List<Query4ProductDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(List<Query4ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

}
