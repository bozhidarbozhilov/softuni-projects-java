package alararestaurant.service;

import alararestaurant.domain.dtos.EmployeeImportDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String ERROR_MESSAGE = "Invalid data format.";

    private static final String EMPLOYEES_JSON_FILE_PATH = "C:\\Users\\Bozhidar Bozhilov\\Desktop" +
            "\\Alara Restaurant_Skeleton\\AlaraRestaurant" +
            "\\src\\main\\resources\\files\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               PositionRepository positionRepository,
                               FileUtil fileUtil, Gson gson,
                               ValidationUtil validationUtil, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public Boolean employeesAreImported() {

       return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder importEmployee = new StringBuilder();
        EmployeeImportDto[] employeeImportDtos = gson.fromJson(employees, EmployeeImportDto[].class);

        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {
            if(!validationUtil.isValid(employeeImportDto) ||
                    !validationUtil.isValid(employeeImportDto.getPosition())){
                importEmployee.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Position position = this.positionRepository
                    .findByName(employeeImportDto.getPosition()).orElse(null);

            if(position == null){
                position = new Position(employeeImportDto.getPosition().trim());
                this.positionRepository.save(position);
            }
            Employee employee = mapper.map(employeeImportDto, Employee.class);
            employee.setPosition(position);

            this.employeeRepository.saveAndFlush(employee);
            importEmployee.append(String.format("Record %s successfully imported.",
                    employee.getName())).append(System.lineSeparator());
        }
        return importEmployee.toString();
    }
}
