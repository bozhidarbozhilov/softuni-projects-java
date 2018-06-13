package p04_Company_Roster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String,List<Employee>> employees = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            Employee currentEmployee = Employee.parseEmployee(scanner.nextLine());
            employees.putIfAbsent(currentEmployee.getDepartment(), new ArrayList<>());

            employees.get(currentEmployee.getDepartment()).add(currentEmployee);
        }

        employees.entrySet().stream().sorted((a, b) ->
                Double.compare(b.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        a.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d-> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    d.getValue().stream().sorted((s1, s2)->Double.compare(s2.getSalary(), s1.getSalary()))
                            .forEach(System.out::println);

                });
    }
}
