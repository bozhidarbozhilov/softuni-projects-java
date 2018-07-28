package borderControl;

public class Citizen implements Identifable{
    private String name;
    private Integer age;
    private String id;

    public Citizen(String name, Integer age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
