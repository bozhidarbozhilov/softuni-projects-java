package p04_Mordors_Cruelty_Plan;

import java.util.*;

public class Wizard {
    private static final Map<String, Integer> GANDALF_FOODS_FOR_HAPPINESS = new LinkedHashMap<>(){{
        put("cram", 2);
        put("lembas", 3);
        put("apple", 1);
        put("melon", 1);
        put("honeycake", 5);
        put("mushrooms", -10);
    }};

    private String name;
    private List<Food> foodsEaten;

    public Wizard(String name){
        this.setName(name);
        this.foodsEaten = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodsEaten() {
        return Collections.unmodifiableList(foodsEaten);
    }

    public void addFoods(List<Food> foods) {
        this.foodsEaten.addAll(foods);
    }

    private int calcMood(){
        int mood=0;
        for(Food food:foodsEaten){
            if(GANDALF_FOODS_FOR_HAPPINESS.containsKey(food.getName())){
                mood += GANDALF_FOODS_FOR_HAPPINESS.get(food.getName());
            }else{
                mood += -1;
            }
        }
        return mood;
    }

    private int getMood(){
        return this.calcMood();
    }

    private String setMood(){
        int mood = this.calcMood();

        if(mood<-5){
            return "Angry";
        }else if(mood<0){
            return "Sad";
        }else if(mood<15){
            return "Happy";
        }else{
            return "JavaScript";
        }
    }

    @Override
    public String toString() {
        return String.format("%d"+System.lineSeparator()+"%s", this.getMood(), this.setMood());
    }
}
