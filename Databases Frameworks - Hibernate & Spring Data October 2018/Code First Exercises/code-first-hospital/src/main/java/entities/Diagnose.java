package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="diagnoses")
public class Diagnose {
    private long id;
    private String name;
    private String comments;
    private Set<Patient> patients;

    public Diagnose() {
    }

    public Diagnose(String name) {
        this.setName(name);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 500)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @ManyToMany(mappedBy = "diagnoses", targetEntity = Patient.class, cascade = CascadeType.ALL)
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
