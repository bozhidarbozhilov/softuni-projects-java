package com.bozhilov.boocarep.domain.models.binding.person;

import com.bozhilov.boocarep.domain.annotations.FieldMatch;
import com.bozhilov.boocarep.domain.annotations.UniqueUsername;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.bozhilov.boocarep.utils.Constants.*;

@FieldMatch(firstField = "password", secondField = "confirmPassword")
public class BasePersonBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String email;

    @NotNull
    @Size(min=USERNAME_MIN_LENGTH,
            max = USERNAME_MAX_LENGTH)
    @UniqueUsername
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(min=PASSWORD_MIN_LENGTH, max=PASSWORD_MAX_LENGTH)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @UniqueUsername
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
