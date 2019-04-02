package com.bozhilov.boocarep.domain.entities.users;

import com.bozhilov.boocarep.domain.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.bozhilov.boocarep.utils.Constants.*;


@MappedSuperclass
public abstract class BasePerson extends BaseEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;


    @NotNull
    @Size(min = USERNAME_MIN_LENGTH,
            max = USERNAME_MAX_LENGTH)
    @Column(name="username", nullable=false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password", nullable=false)
    @Size(min=PASSWORD_MIN_LENGTH,
            max=PASSWORD_MAX_LENGTH)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name="last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Email
    @Column(name="email", nullable=false, unique=true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
