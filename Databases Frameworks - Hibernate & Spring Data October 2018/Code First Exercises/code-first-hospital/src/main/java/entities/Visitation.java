package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="visitations")
public class Visitation {
    private long id;
    private LocalDateTime date;
    private String comment;
    private Patient patient;

    public Visitation() {
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
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Basic
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
