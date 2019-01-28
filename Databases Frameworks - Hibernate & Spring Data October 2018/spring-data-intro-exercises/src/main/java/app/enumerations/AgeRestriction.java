package app.enumerations;

public enum AgeRestriction {
    MINOR(0), TEEN(1), ADULT(2);

    private final int ageRestrictionLevel;

    private AgeRestriction(int i) {
        this.ageRestrictionLevel=i;
    }
}
