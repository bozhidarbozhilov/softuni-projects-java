package com.bozhilov.boocarep.service.employee;

import com.bozhilov.boocarep.domain.models.service.EmployeeServiceModel;

import java.io.InvalidObjectException;
import java.util.List;

public interface EmployeeService {
    EmployeeServiceModel saveEmployee(EmployeeServiceModel employeeServiceModel) throws InvalidObjectException;
    List<EmployeeServiceModel> findAllEmployee();
    EmployeeServiceModel findEmployeeByUsername(String username);
    EmployeeServiceModel findEmployeeByEmail(String email);
}
