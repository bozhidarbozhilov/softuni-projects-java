package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student extends BaseEntity {
    private Double averageGrade;
    private Integer attendance;
    private Set<Course> courses;

    public Student(){
        this.courses = new HashSet<>();
    }

    public Student(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        this.courses=new HashSet<>();
    }

    @Basic
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Basic
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students", targetEntity = Course.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
