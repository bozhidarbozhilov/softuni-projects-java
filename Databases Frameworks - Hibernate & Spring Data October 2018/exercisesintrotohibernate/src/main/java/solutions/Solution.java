package solutions;

import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;
import intefaces.Readable;
import intefaces.Writable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private final EntityManager entityManager;
    private final Writable writer;
    private final Readable reader;

    public Solution(EntityManager em, Writable writer, Readable reader){
        this.entityManager = em;
        this.writer = writer;
        this.reader = reader;
    }

    public void p01_RemoveObjects(){
        Query selectAllTownsQuery = entityManager.createQuery("select t from Town t where length(t.name)>5 ");
        List<Town> towns = selectAllTownsQuery.getResultList();
        entityManager.getTransaction().begin();
        for (Town town : towns) {
            entityManager.detach(town);
            town.setName(town.getName().toLowerCase());
            entityManager.merge(town);
        }
        entityManager.getTransaction().commit();

    }

    public void p02_ContainsEmployee(){
        this.writer.write("Enter name for search: ");
        String[] nameToSearch = this.reader.readLine().trim().split("\\s+");
        String firstName = nameToSearch[0];
        String lastName = nameToSearch[1];

        Query checkDBForGivenName =
                entityManager.createQuery("select e " +
                        "from Employee e where e.firstName=:employeeFirstName and e.lastName=:employeeLastName")
                        .setParameter("employeeFirstName", firstName)
                        .setParameter("employeeLastName", lastName);
        List<Employee> result = checkDBForGivenName.getResultList();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        if(result.size() > 0){
            this.writer.writeLine("Yes");
        }else{
            this.writer.writeLine("No");
        }
    }

    public void p03_EmployeesWithSalaryOver50000(){
        Query getEmployeeBySalary =
                entityManager.createQuery("select e.firstName " +
                        "from Employee e where e.salary > 50000");
        List<String> result = getEmployeeBySalary.getResultList();
        entityManager.getTransaction().begin();
        for (String employee : result) {
            writer.writeLine(employee);
        }
        entityManager.getTransaction().commit();
    }

    public void p04_EmployeesFromDepartment(){
        Query getEmployeeByDepartment =
                entityManager.createQuery("select e " +
                        "from Employee e where e.department.name = 'Research and Development' " +
                        "order by e.salary, e.id");
        List<Employee> result = getEmployeeByDepartment.getResultList();
        entityManager.getTransaction().begin();
        for (Employee employee : result) {
            writer.writeLine(employee.getFirstName() + " " + employee.getLastName()
            + " from " + employee.getDepartment().getName() +" - $" +employee.getSalary());
        }
        entityManager.getTransaction().commit();
    }

    public void p05_AddingNewAddressAndUpdatingEmployee(){
       //insert address "Vitoshka 15"
/*        Address addressToInsert = new Address();
        addressToInsert.setText("Vitoshka 15");
        entityManager.getTransaction().begin();
        entityManager.persist(addressToInsert);
        entityManager.getTransaction().commit();*/

        this.writer.write("Enter employee last last name to set new address: ");
        String employeeLastName = this.reader.readLine();

        Query setNewAddressToEmployee = this.entityManager
                .createQuery("update Employee e " +
                        "set e.address.id = (select a.id from Address a where a.text=:addressName) " +
                        "where e.lastName=:enteredLastName")
                .setParameter("addressName", "Vitoshka 15")
                .setParameter("enteredLastName", employeeLastName);
        entityManager.getTransaction().begin();
        setNewAddressToEmployee.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void p06_AddressesWithEmployeeCount(){
        Query countEmployeesByAddress =
                entityManager.createQuery("select a " +
                        "from Address a " +
                        "order by a.employees.size desc, a.town.id asc ").setMaxResults(10);

        List<Address> result = countEmployeesByAddress.getResultList();

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        result.stream().forEach(address ->
                this.writer.writeLine(address.getText()+", "+address.getTown().getName()+ " - "
                        +address.getEmployees().size()+ " employees"));
    }

    public void p07_GetEmployeeWithProject(){
        this.writer.write("Enter Employee Id To Get Information: ");
        Integer idToSelect = Integer.valueOf(this.reader.readLine().trim());
        Query getEmployee = entityManager.createQuery("select e from Employee e " +
                "where e.id=:id").setParameter("id", idToSelect);

        entityManager.getTransaction().begin();
        Employee returnedEmployee = (Employee) getEmployee.getSingleResult();
        entityManager.getTransaction().commit();

        this.writer.writeLine(returnedEmployee.getFirstName() + " " +returnedEmployee.getLastName()
        +" - "+returnedEmployee.getJobTitle());
        returnedEmployee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> this.writer.writeLine("\t"+project.getName()));
    }

    public void p08_FindLatest10Projects(){
        Query getLatest10Projects = entityManager.createQuery("select p from Project p " +
                "order by p.startDate desc ").setMaxResults(10);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        List<Project> returnedProjects = getLatest10Projects.getResultList();

        returnedProjects.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    this.writer.writeLine("Project name: " + project.getName());
                    this.writer.writeLine("\t\tProject Description: " + project.getDescription());
                    this.writer.writeLine("\t\tProject Start Date:" + project.getStartDate());
                    this.writer.writeLine("\t\tProject End Date: " + project.getEndDate());
                });
    }

    public void p09_IncreaseSalaries(){
        Query getEmployeesFromSeveralDepartments = entityManager
                .createQuery("select e from Employee e " +
                        "where e.department.name in " +
                        "('Engineering', 'Tool Design', 'Marketing','Information Services') ", Employee.class);

        entityManager.getTransaction().begin();
        List<Employee> result =  getEmployeesFromSeveralDepartments.getResultList();

        for (Employee employee : result) {
            entityManager.detach(employee);
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.merge(employee);
            this.writer.writeLine(employee.getFirstName()+" "+employee.getLastName() + " ($"+
                    employee.getSalary()+")");
        }
        entityManager.getTransaction().commit();
    }

    public void p10_RemoveTowns(){
        this.writer.write("Enter town name you want to delete: ");
        String townToDelete = this.reader.readLine();
        entityManager.getTransaction().begin();
        Query selectAddressesInTheTown = entityManager.createQuery("select a from Address a " +
                "where a.town.name=:townName",Address.class).setParameter("townName", townToDelete);

        Query deleteTown = entityManager.createQuery("delete from Town t " +
                "where t.name=:townName").setParameter("townName", townToDelete);

        List<Address> selectedAddresses = selectAddressesInTheTown.getResultList();
        if(selectedAddresses.size()==0){
            this.writer.writeLine("The town not exists in database");
            return;
        }
        for (Address address : selectedAddresses) {
            entityManager.remove(address);
        }
        deleteTown.executeUpdate();
        entityManager.getTransaction().commit();

        this.writer.writeLine(selectedAddresses.size() + " address in "+townToDelete+" deleted");
    }

    public void p11_FindEmployeesByFirstName(){
        this.writer.write("Enter pattern of first name for remove: ");
        String pattern = this.reader.readLine();

        entityManager.getTransaction().begin();
        Query selectEmployeesByPatternOfName = this.entityManager.createQuery("select e from Employee e " +
                "where e.firstName like :pattern", Employee.class)
                .setParameter("pattern", pattern + "%");

        List<Employee> selectedEmployees = selectEmployeesByPatternOfName.getResultList();
        entityManager.getTransaction().commit();

        selectedEmployees.forEach(employee ->
                this.writer.writeLine(employee.getFirstName() +" "+employee.getLastName()
                +" - "+ employee.getJobTitle() + " ($"+employee.getSalary()+ ")"));
    }

    public void p12_EmployeesMaximumSalaries(){
        entityManager.getTransaction().begin();
        Query selectMaxSalariesByDepartment = entityManager
                .createQuery("select e.department.name, max(e.salary) from Employee e  " +
                        "group by e.department.name having max(e.salary) not between 30000 and 70000 ");
        entityManager.getTransaction().commit();
        List selectedColumns = selectMaxSalariesByDepartment.getResultList();
        selectedColumns.forEach(row->{
            Object[] currentRow = (Object[]) row;
            this.writer.writeLine(currentRow[0] + " - " +currentRow[1]);
        });
    }

}
