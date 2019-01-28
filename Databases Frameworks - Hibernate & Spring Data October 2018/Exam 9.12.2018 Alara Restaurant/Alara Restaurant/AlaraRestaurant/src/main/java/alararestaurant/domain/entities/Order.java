package alararestaurant.domain.entities;

import alararestaurant.domain.OrderType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name="orders")
public class Order extends BaseEntity {
    private String customer;
    private LocalDateTime dateTime;
    private OrderType type;
    private Employee employee;
    private Set<OrderItem> orderItems;

    @Column(name="customer", nullable = false, columnDefinition = "TEXT")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name="date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="type", length = 10,
            nullable = false,columnDefinition = "ENUM('ForHere', 'ToGo') DEFAULT 'ForHere'")
    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name="employee_id",referencedColumnName = "id")
    @NotNull
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class)
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
