package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ImportItemDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String category;

    @NotNull
    @Size(min=3,max=30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @DecimalMin(value = "0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @NotNull
    @Size(min=3,max=30)
    public String getCategoryName() {
        return category;
    }

    public void setCategoryName(String categoryName) {
        this.category = categoryName;
    }
}
