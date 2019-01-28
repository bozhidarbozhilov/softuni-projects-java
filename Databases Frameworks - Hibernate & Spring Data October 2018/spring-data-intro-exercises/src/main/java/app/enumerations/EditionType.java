package app.enumerations;

public enum EditionType {
    NORMAL(0), PROMO(1), GOLD(2);
    private final int editionLevel;

    private EditionType(int editionLevel) {
        this.editionLevel = editionLevel;
    }
}
