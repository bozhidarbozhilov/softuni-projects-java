package app.models.dtos.view;

import app.models.dtos.binding.CreateCarDto;
import app.models.entities.Car;
import app.models.entities.Sale;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class SalesDiscountDto {
    private CreateCarDto car;
    private String customerName;
    private int discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;


    public CreateCarDto getCar() {
        return car;
    }

    public void setCar(CreateCarDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

/*    public static void configureMapping(ModelMapper mapper){
        BigDecimal sum = BigDecimal.ZERO;
        mapper.createTypeMap(Sale.class, SalesDiscountDto.class)
                .addMapping(src->src.getCar().getParts().stream().
                        map(part -> sum.add(part.getPrice())),
                        SalesDiscountDto::setPrice);
    }*/
}
