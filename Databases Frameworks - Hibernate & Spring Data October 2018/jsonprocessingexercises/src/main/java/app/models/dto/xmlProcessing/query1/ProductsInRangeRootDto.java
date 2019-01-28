package app.models.dto.xmlProcessing.query1;

import app.models.dto.NoBuyerProductsDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeRootDto {
    @XmlElement(name="product")
    private List<NoBuyerProductsDto> productsInRangeDtoList;

    public ProductsInRangeRootDto() {
    }

    public List<NoBuyerProductsDto> getProductsInRangeDtoList() {
        return productsInRangeDtoList;
    }

    public void setProductsInRangeDtoList(List<NoBuyerProductsDto> productsInRangeDtoList) {
        this.productsInRangeDtoList = productsInRangeDtoList;
    }
}
