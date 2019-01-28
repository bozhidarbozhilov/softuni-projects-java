package app.models.dto.xmlProcessing.query3;

import app.models.dto.CategoryByProductsDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryByProductsRootDto {
    @XmlElement(name="category")
    private List<CategoryByProductsDto> categories;


    public List<CategoryByProductsDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryByProductsDto> categories) {
        this.categories = categories;
    }
}
