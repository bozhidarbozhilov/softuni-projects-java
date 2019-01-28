package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="medicaments")
public class Medicament {
    private long id;
    private String name;
    private Set<Patient> patients;

    public Medicament() {
    }

    public Medicament(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setName(name);
    }

    @ManyToMany(mappedBy = "medicaments", targetEntity = Patient.class, cascade = CascadeType.ALL)
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
