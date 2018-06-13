package p06_Raw_Data;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres =new ArrayList<>();
    }

    public void addTyre(Tyre tyre){
        this.tyres.add(tyre);
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tyre> getTyres() {
        return this.tyres;
    }
}
