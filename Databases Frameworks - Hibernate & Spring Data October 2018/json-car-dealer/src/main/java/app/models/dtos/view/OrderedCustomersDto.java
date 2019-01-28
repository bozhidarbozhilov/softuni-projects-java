package app.models.dtos.view;

import app.models.entities.Customer;
import app.models.entities.Sale;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderedCustomersDto {
    private long id;
    private String name;
    private Date birthDate;
    private boolean isYoungDriver;
    private Set<WithoutCustomerSaleDto> sales;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<WithoutCustomerSaleDto> getSales() {
        return sales;
    }

    public void setSales(Set<WithoutCustomerSaleDto> sales) {
        this.sales = sales;
    }

}
