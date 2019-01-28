package alararestaurant.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface EmployeeService {

    Boolean employeesAreImported();

    String readEmployeesJsonFile() throws IOException;

    String importEmployees(String employees);
}
