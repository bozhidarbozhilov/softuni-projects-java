package app.domain.entities;

import app.domain.enums.ProductType;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    private long id;
    private String name;
    private String description;
    private ProductType productType;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="product_type")
    @Enumerated(EnumType.STRING)
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
