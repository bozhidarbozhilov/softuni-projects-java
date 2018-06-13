package p06_Raw_Data;

public class Tyre {
    private int age;
    private double pressure;

    public Tyre(int age, double pressure){
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}
