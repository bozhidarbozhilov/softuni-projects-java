package comparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        if(this.getName().compareTo(other.getName()) == 0){
            if(this.getAge()==other.getAge()){
                return this.getTown().compareTo(other.getTown());
            }else{
                return this.getAge() - other.getAge() ;
            }
        }
        return this.getName().compareTo(other.getName());
    }
}
