package app.models.dtos.view;

import app.models.dtos.binding.CreateCarDto;
import app.models.entities.Car;

public class WithoutCustomerSaleDto {
    private long id;
    private int discount;
    private CreateCarDto car;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public CreateCarDto getCar() {
        return car;
    }

    public void setCar(CreateCarDto car) {
        this.car = car;
    }
}
