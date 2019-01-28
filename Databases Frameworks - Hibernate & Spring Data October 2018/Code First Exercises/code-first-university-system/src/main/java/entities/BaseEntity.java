package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    protected BaseEntity() {
    }

    protected BaseEntity(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="first_name", nullable = false, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name", nullable = false, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
