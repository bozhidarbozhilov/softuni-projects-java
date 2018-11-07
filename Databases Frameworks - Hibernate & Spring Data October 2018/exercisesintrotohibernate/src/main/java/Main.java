import entities.Town;
import intefaces.Readable;
import intefaces.Writable;
import io.ConsoleReader;
import io.ConsoleWriter;
import solutions.Solution;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class Main {
    private static Scanner scanner  ;
    private static Writable consoleWriter  ;
    private static Readable consoleReader ;
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        consoleWriter = new ConsoleWriter();
        consoleReader = new ConsoleReader(scanner);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        Solution solutionOf = new Solution(em, consoleWriter, consoleReader);
        printSolutions();
        int numberOfSolution = Integer.parseInt(consoleReader.readLine());
        runSolution(numberOfSolution, solutionOf);

    }

    private static void runSolution(int numberOfSolution, Solution solution) {
         switch (numberOfSolution){
             case 1:
                 solution.p01_RemoveObjects();
                 break;
             case 2:
                 solution.p02_ContainsEmployee();
                 break;
             case 3:
                 solution.p03_EmployeesWithSalaryOver50000();
                 break;
             case 4:
                 solution.p04_EmployeesFromDepartment();
                 break;
             case 5:
                 solution.p05_AddingNewAddressAndUpdatingEmployee();
                 break;
             case 6:
                 solution.p06_AddressesWithEmployeeCount();
                 break;
             case 7:
                 solution.p07_GetEmployeeWithProject();
                 break;
             case 8:
                 solution.p08_FindLatest10Projects();
                 break;
             case 9:
                 solution.p09_IncreaseSalaries();
                 break;
             case 10:
                 solution.p10_RemoveTowns();
                 break;
             case 11:
                 solution.p11_FindEmployeesByFirstName();
                 break;
             case 12:
                 solution.p12_EmployeesMaximumSalaries();
                 break;
             default:
                 break;
         }

    }

    private static void printSolutions() {

        consoleWriter.writeLine("1. Remove Objects.");
        consoleWriter.writeLine("2. Contains Employee.");
        consoleWriter.writeLine("3. Employees with Salary Over 50 000.");
        consoleWriter.writeLine("4. Employees from Department");
        consoleWriter.writeLine("5. Adding a New Address and Updating Employee");
        consoleWriter.writeLine("6. Addresses with Employee Count.");
        consoleWriter.writeLine("7. Get Employee with Project.");
        consoleWriter.writeLine("8. Find Latest 10 Projects.");
        consoleWriter.writeLine("9. Increase Salaries");
        consoleWriter.writeLine("10. Remove Towns.");
        consoleWriter.writeLine("11. Find Employees by First Name.");
        consoleWriter.writeLine("12. Employees Maximum Salaries.");
        consoleWriter.write("Select The Number Of Solution (1-12): ");
    }

}
