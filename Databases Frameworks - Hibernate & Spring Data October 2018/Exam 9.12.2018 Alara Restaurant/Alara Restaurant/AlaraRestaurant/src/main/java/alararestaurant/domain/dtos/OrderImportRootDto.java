package alararestaurant.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderImportRootDto {
    @XmlElement(name="order")
    private OrderImportDto[] orders;

    public OrderImportDto[] getOrders() {
        return orders;
    }

    public void setOrders(OrderImportDto[] orders) {
        this.orders = orders;
    }
}
