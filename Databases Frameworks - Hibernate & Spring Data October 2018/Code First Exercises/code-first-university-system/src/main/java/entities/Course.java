package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    private int id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer credits;
    private Set<Student> students;
    private Teacher teacher;



    public Course() {
        students=new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Basic
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Basic
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="students_courses",
            joinColumns = @JoinColumn(name="course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
