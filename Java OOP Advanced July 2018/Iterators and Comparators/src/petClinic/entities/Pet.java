package petClinic.entities;

import static petClinic.utilities.Constants.EXCEPTION_MESSAGE;
import static petClinic.utilities.Constants.NAME_VALIDATOR;

public class Pet {
    private String name;
    private int age;
    private String type;

    public Pet(String name, int age, String type) {
        this.setName(name);
        this.setAge(age);
        this.setType(type);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(!name.matches(NAME_VALIDATOR)){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        if(age<1 || age>100){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        if(!type.matches(NAME_VALIDATOR)){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getType());
        return output.toString();
    }
}
