package com.bozhilov.boocarep.domain.annotations;

import com.bozhilov.boocarep.repository.EmployeeRepository;
import com.bozhilov.boocarep.service.employee.EmployeeService;
import com.bozhilov.boocarep.service.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
   private final UserService userService;
   private final EmployeeService employeeService;

   public UniqueEmailValidator(UserService userService, EmployeeService employeeService) {
      this.userService = userService;
      this.employeeService = employeeService;
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {

      return this.userService.findUserByEmail(email) == null &&
              this.employeeService.findEmployeeByEmail(email)==null;
   }
}
