package com.bozhilov.boocarep.service.employee;

import com.bozhilov.boocarep.domain.entities.users.Employee;
import com.bozhilov.boocarep.domain.models.service.EmployeeServiceModel;
import com.bozhilov.boocarep.repository.EmployeeRepository;
import com.bozhilov.boocarep.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.io.InvalidObjectException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, Validator validator) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public EmployeeServiceModel saveEmployee(EmployeeServiceModel employeeServiceModel) throws InvalidObjectException {
        if(this.validator.validate(employeeServiceModel).size()>0){
            throw new InvalidObjectException(Constants.INVALID_EMPLOYEE_PROPERTIES_MESSAGE);
        }
        Employee savedEmployee = this.employeeRepository
                .save(this.modelMapper.map(employeeServiceModel, Employee.class));

        return this.modelMapper.map(savedEmployee, EmployeeServiceModel.class);
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployee() {
        return this.employeeRepository.findAll().stream().
                map(employee -> this.modelMapper.map(employee, EmployeeServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public EmployeeServiceModel findEmployeeByUsername(String username) {
        Employee foundEmployee = this.employeeRepository.findByUsername(username);
        if(foundEmployee == null){
            return null;
        }
        return this.modelMapper.map(foundEmployee, EmployeeServiceModel.class);
    }

    @Override
    public EmployeeServiceModel findEmployeeByEmail(String email) {
        Employee foundEmployee = this.employeeRepository.findByEmail(email);
        if(foundEmployee == null){
            return null;
        }
        return this.modelMapper.map(foundEmployee, EmployeeServiceModel.class);
    }
}
