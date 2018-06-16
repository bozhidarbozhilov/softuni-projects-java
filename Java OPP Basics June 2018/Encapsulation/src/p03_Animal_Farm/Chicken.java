package p03_Animal_Farm;

public class Chicken {
    private String name;
    private Integer age;
    private Double productPerDay;

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.length() < 1 || name.isEmpty() || name == null || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public Double productPerDay() {
        return this.calculateProductPerDay();
    }


    private Double calculateProductPerDay() {
        if(this.getAge()>=0 && this.getAge()<=5){
            this.productPerDay = 2.0;
        }else if(this.getAge()>=6 && this.getAge()<=11){
            this.productPerDay = 1.0;
        }else{
            this.productPerDay = 0.75;
        }

        return this.productPerDay;
    }
}
