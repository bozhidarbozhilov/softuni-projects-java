package app.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set<Product> soldProducts;
    private Set<Product> boughtProducts;
    private List<User> friends;

    public User() {
        this.soldProducts = new HashSet<>();
        this.boughtProducts = new HashSet<>();
        this.friends = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name", nullable = false)
    @Size(min = 3, message = "User's last name must be at least 3 characters long.")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "seller",targetEntity = Product.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    @OneToMany(mappedBy = "buyer", targetEntity = Product.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Set<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="users_friends",
    joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="friend_id", referencedColumnName="id"))
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
