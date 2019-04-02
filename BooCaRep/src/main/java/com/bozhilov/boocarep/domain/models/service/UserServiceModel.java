package com.bozhilov.boocarep.domain.models.service;

import com.bozhilov.boocarep.domain.annotations.UniquePhoneNumber;
import com.bozhilov.boocarep.domain.entities.users.Title;

import javax.validation.constraints.NotNull;

public class UserServiceModel extends BasePersonServiceModel{
    private String phoneNumber;
    private String address;
    private Title title;
    private String info;

    @NotNull
    @UniquePhoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
