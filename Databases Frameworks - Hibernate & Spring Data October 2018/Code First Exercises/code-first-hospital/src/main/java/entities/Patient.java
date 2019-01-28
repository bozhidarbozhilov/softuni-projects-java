package entities;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="patients")
public class Patient {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private Boolean isMedicalInsurance;
    private Set<Visitation> visitations;
    private Set<Medicament> medicaments;
    private Set<Diagnose> diagnoses;

    public Patient() {
    }
    public Patient(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @Column(name="last_name", nullable=false, length=30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(columnDefinition = "BLOB")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name="is_medical_insurance")
    public Boolean getMedicalInsurance() {
        return isMedicalInsurance;
    }

    public void setMedicalInsurance(Boolean medicalInsurance) {
        isMedicalInsurance = medicalInsurance;
    }

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="patients_medicaments",
    joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="medicament_id", referencedColumnName = "id"))
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="patients_diagnoses",
    joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="diagnose_id", referencedColumnName = "id"))
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
