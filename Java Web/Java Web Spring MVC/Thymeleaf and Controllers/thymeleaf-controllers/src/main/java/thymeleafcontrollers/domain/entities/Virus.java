package thymeleafcontrollers.domain.entities;

import org.springframework.format.annotation.DateTimeFormat;
import thymeleafcontrollers.annotation.BeforeToday;
import thymeleafcontrollers.domain.enumeration.Magnitude;
import thymeleafcontrollers.domain.enumeration.Mutation;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="viruses")
public class Virus  extends BaseEntity{

    private String name;
    private String description;
    private String sideEffects;
    private String creator;
    private boolean isDeadly;
    private boolean isCurable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer hourUntilTurn;
    private Magnitude magnitude;
    private Date releasedOn;
    private Set<Capital> capitals;

    @NotBlank
    @Size(min=3, max = 10)
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Size(min=5, max = 100)
    @Column(name="description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank
    @Size(max = 50)
    @Column(name="side_effects")
    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Pattern(regexp = "^.*[Cc]orp$")
    @Column(name="creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name="is_deadly")
    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    @Column(name="is_curable")
    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="mutation")
    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Min(0)
    @Max(100)
    @Column(name="turn_over_rate")
    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @NotNull
    @Min(1)
    @Max(12)
    public Integer getHourUntilTurn() {
        return hourUntilTurn;
    }

    public void setHourUntilTurn(Integer hourUntilTurn) {
        this.hourUntilTurn = hourUntilTurn;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="magnitude")
    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @BeforeToday
    @Column(name="released_on", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    @ManyToMany
    @JoinTable(name="viruses_capitals",
    joinColumns = @JoinColumn(name="virus_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="capital_id", referencedColumnName = "id"))
    public Set<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
    }
}
