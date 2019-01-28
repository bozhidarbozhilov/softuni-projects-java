package app.models.dto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryByProductsDto {
    @XmlAttribute(name= "name")
    private String name;
    @XmlElement(name="products-count")
    private Integer productsCount;
    @XmlElement(name="average-price")
    private Double averagePrice;
    @XmlElement(name="total-revenue")
    private BigDecimal totalRevenue;

    public CategoryByProductsDto() {
    }

    public CategoryByProductsDto(String name, Integer productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
