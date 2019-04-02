package thymeleafcontrollers.domain.models.binding;

import org.springframework.format.annotation.DateTimeFormat;
import thymeleafcontrollers.annotation.BeforeToday;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class VirusBindingModel {

    private String name;
    private String description;
    private String sideEffects;
    private String creator;
    private boolean isDeadly;
    private boolean isCurable;
    private String mutation;
    private Integer turnoverRate;
    private Integer hourUntilTurn;
    private String magnitude;
    private Date releasedOn;
    private Set<String> capitals;

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    @NotBlank(message = "The field cannot be empty")
    @Size(min=3, max = 10, message="Name size must be between 3 and 10 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "The field cannot be empty")
    @Size(min=5, max = 100, message="Description size must be between 3 and 10 characters.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank(message = "The field cannot be empty")
    @Size(max = 50, message="Side Effects size must be up to 50 characters.")
    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Pattern(regexp = "^.*[Cc]orp$", message = "Creator have to be corp.")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean getIsDeadly() {
        return isDeadly;
    }

    public void setIsDeadly(boolean isDeadly) {
        this.isDeadly = isDeadly;
    }

    public boolean getIsCurable() {
        return isCurable;
    }

    public void setIsCurable(boolean isCurable) {
        this.isCurable = isCurable;
    }

    @NotNull(message = "The field cannot be empty")
    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    @Min(value = 0, message="Must be greater than zero.")
    @Max(value = 100, message="Must be smaller than 100.")
    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @NotNull(message = "The field cannot be empty")
    @Min(1)
    @Max(12)
    public Integer getHourUntilTurn() {
        return hourUntilTurn;
    }

    public void setHourUntilTurn(Integer hourUntilTurn) {
        this.hourUntilTurn = hourUntilTurn;
    }

    @NotNull(message = "The field cannot be empty")
    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @BeforeToday
    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    @NotEmpty(message = "Have to choose at least one capital.")
    public Set<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<String> capitals) {
        this.capitals = capitals;
    }
}
