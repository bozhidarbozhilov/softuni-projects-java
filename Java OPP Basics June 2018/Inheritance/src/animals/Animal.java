package animals;

public class Animal {
    private static final String EXCEPTION_MESSAGE = "Invalid input!";
    private String name;
    private String age;
    private String gender;

    public Animal(){
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if(name==null || name.equals(" ") || name.isEmpty()){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    protected  String getAge() {
        return this.age;
    }

    protected  void setAge(String age) {
        if(age==null || age.equals(" ") || age.isEmpty()|| !Character.isDigit(age.charAt(0)) || Integer.parseInt(age)<=0){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.age = age;
    }

    protected  String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if(gender==null||gender.isEmpty() || gender.equals(" ")){
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE);
        }
        this.gender = gender;
    }
    protected String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "%s %s %s%n" +
                "%s%n", this.getClass().getSimpleName(),
                this.getName(), this.getAge(), this.getGender(),
                this.produceSound());
    }
}
