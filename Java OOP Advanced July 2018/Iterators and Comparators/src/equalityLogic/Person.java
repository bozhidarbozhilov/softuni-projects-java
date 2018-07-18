package equalityLogic;


public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person castObject = (Person) obj;

        return this.getName().equals(castObject.getName()) && this.getAge()==castObject.getAge();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getName().hashCode();
        result = 31 * result + this.age;
        return result;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }

    @Override
    public int compareTo(Person o) {
        if(!this.equals(o)){
            return this.hashCode()-o.hashCode();
        }
        return 0;
    }
}
