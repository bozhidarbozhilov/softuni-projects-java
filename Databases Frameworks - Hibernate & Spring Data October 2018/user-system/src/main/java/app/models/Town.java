package app.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="towns")
public class Town {
    private int id;
    private String name;
    private String country;
    private Set<User> usersBorn;
    private Set<User> usersLived;

    public Town() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "liveTown", targetEntity = User.class)
    public Set<User> getUsersLived() {
        return usersLived;
    }

    public void setUsersLived(Set<User> usersLived) {
        this.usersLived = usersLived;
    }

    @OneToMany(mappedBy = "bornTown", targetEntity = User.class)
    public Set<User> getUsersBorn() {
        return usersBorn;
    }

    public void setUsersBorn(Set<User> usersBorn) {
        this.usersBorn = usersBorn;
    }
}
