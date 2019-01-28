package app.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="suppliers")
public class Supplier {
    private long id;
    private String name;
    private boolean isImporter;
    private Set<Part> suppliedParts;

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
        this.name = name;
    }

    @Column(name="is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier", targetEntity = Part.class,fetch = FetchType.EAGER)
    public Set<Part> getSuppliedParts() {
        return suppliedParts;
    }

    public void setSuppliedParts(Set<Part> suppliedParts) {
        this.suppliedParts = suppliedParts;
    }
}
