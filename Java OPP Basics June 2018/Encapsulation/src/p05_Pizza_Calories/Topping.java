package p05_Pizza_Calories;

import java.util.LinkedHashMap;
import java.util.Map;

public class Topping {
    private static final Double DEFAULT_TOPPING_CALORIES = 2.0;
    private static final Map<String, Double> TOPPING_TYPE_MODIFIERS = new LinkedHashMap<>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Chewy", 1.1);
        put("Sauce", 0.9);
    }};

    private String toppingType;
    private Double weightInGrams;

    public Topping(String toppingType, Double weightInGrams) {
        this.setToppingType(toppingType);
        this.setWeightInGrams(toppingType, weightInGrams);
    }

    public String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_TYPE_MODIFIERS.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public Double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(String toppingType, Double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weightInGrams = weightInGrams;
    }

    Double calcToppingCalories(){
        Double calories = DEFAULT_TOPPING_CALORIES * this.getWeightInGrams()*
                TOPPING_TYPE_MODIFIERS.get(this.getToppingType());
        return calories;
    }
}
