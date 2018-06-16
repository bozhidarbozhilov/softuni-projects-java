package p05_Pizza_Calories;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dough {
    private static final Double DEFAULT_DOUGH_CALORIES = 2.0;
    private static final Map<String, Double> DOUGH_TYPE_MODIFIERS = new LinkedHashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    private String flourType;
    private String bakingType;
    private Double weightInGrams;

    public Dough(String flourType, String bakingType, Double weightInGrams){
        this.setFlourType(flourType);
        this.setBakingType(bakingType);
        this.setWeightInGrams(weightInGrams);
    }

    public String getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        if(!DOUGH_TYPE_MODIFIERS.containsKey(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getBakingType() {
        return this.bakingType;
    }

    private void setBakingType(String bakingType) {
        if(!DOUGH_TYPE_MODIFIERS.containsKey(bakingType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingType = bakingType;
    }

    public Double getWeightInGrams() {
        return this.weightInGrams;
    }

    private void setWeightInGrams(Double weightInGrams) {
        if(weightInGrams < 1 || weightInGrams>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }
    Double calcDoughCalories(){
        Double calories = (DEFAULT_DOUGH_CALORIES * this.getWeightInGrams())
                * DOUGH_TYPE_MODIFIERS.get(this.getFlourType())
                *DOUGH_TYPE_MODIFIERS.get(this.getBakingType());
        return calories;
    }
}
