package defineInterfacePerson;

public class Citizen implements Person {
    private String name;
    private Integer age;

    public Citizen (String name, Integer age){
        this.setName(name);
        this.setAge(age);
    }
    @Override
    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        this.name = name;
    }
    @Override
    public Integer getAge() {
        return this.age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
