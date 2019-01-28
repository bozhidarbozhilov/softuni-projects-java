package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="teachers")
public class Teacher extends BaseEntity {
    private String email;
    private BigDecimal salaryPerHour;
    private Set<Course> courses;

    public Teacher() {
        this.courses= new HashSet<>();
    }

    public Teacher(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        this.courses = new HashSet<>();
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class, cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
