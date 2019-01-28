package app.models.dto.xmlProcessing.query2;

import app.models.dto.SoldProductDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement(name="sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductRootDto {

    @XmlElement(name="product")
    private Set<SoldProductDto> soldProductDtos;

    public SoldProductRootDto() {
    }

    public Set<SoldProductDto> getSoldProductDtos() {
        return soldProductDtos;
    }

    public void setSoldProductDtos(Set<SoldProductDto> soldProductDtos) {
        this.soldProductDtos = soldProductDtos;
    }
}
