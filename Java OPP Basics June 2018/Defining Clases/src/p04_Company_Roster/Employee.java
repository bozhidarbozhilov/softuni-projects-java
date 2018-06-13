package p04_Company_Roster;

public class Employee {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;


    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public static Employee parseEmployee(String input){
        String[] tokens = input.split("\\s+");

        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        String position = tokens[2];
        String department = tokens[3];
        String email = DEFAULT_EMAIL;
        int age = DEFAULT_AGE;

        if(tokens.length==5){
            try{
                age = Integer.parseInt(tokens[4]);
            }catch(Exception e){
                email = tokens[4];
            }
        }else if(tokens.length == 6){
            email = tokens[4];
            age = Integer.parseInt(tokens[5]);
        }else{

        }
        return new Employee(name, salary, position, department, email, age);
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
