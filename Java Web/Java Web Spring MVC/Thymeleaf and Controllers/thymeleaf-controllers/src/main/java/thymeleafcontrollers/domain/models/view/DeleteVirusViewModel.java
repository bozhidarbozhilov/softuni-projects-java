package thymeleafcontrollers.domain.models.view;

import java.util.Date;
import java.util.Set;

public class DeleteVirusViewModel {
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

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

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHourUntilTurn() {
        return hourUntilTurn;
    }

    public void setHourUntilTurn(Integer hourUntilTurn) {
        this.hourUntilTurn = hourUntilTurn;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    public Set<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<String> capitals) {
        this.capitals = capitals;
    }
}
