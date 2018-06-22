package p03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workingHours;

    public Worker(String firstName, String lastName, double weekSalary, double workingHours) {
        super(firstName, lastName);
        this.setSalary(weekSalary);
        this.setWorkingHours(workingHours);
    }

    private void setSalary(double salary) {
        if (salary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = salary;
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours < 1 || workingHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    private double getWorkingHours() {
        return workingHours;
    }

    private double getSalaryPerHour() {
        return (this.getWeekSalary()/7) / this.getWorkingHours();
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 2) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }


    @Override
    public String toString() {
        return super.toString()+String.format("Week Salary: %.2f" + System.lineSeparator() +
                "Hours per day: %.2f" + System.lineSeparator() +
                "Salary per hour: %.2f"+System.lineSeparator(),
                this.getWeekSalary(), this.getWorkingHours(), this.getSalaryPerHour());
    }
}
