package com.bozhilov.boocarep.domain.entities.users;

import com.bozhilov.boocarep.domain.entities.tech.Car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BasePerson{
    private String phoneNumber;
    private String address;
    private Title title;
    private String info;
    private Set<Car> cars;

    @NotNull
    @Column(name="phone_number", nullable = false, unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="title", nullable=false)
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Column(name="info", columnDefinition = "TEXT")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @OneToMany(mappedBy = "owner", targetEntity = Car.class)
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
