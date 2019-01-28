package app.models.dto.bindingModels;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateProductDto {
    private String name;
    private BigDecimal price;
    @Size(min = 3, message = "Product name must be at least 3 characters long.")
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
}
