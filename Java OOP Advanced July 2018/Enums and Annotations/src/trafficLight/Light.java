package trafficLight;

public enum Light {
    RED, GREEN, YELLOW;

    private static Light[] lights = values();

    public Light next() {
        return lights[(this.ordinal() + 1) % lights.length];
    }
}
