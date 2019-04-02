package com.bozhilov.boocarep.domain.annotations;

import com.bozhilov.boocarep.repository.EmployeeRepository;
import com.bozhilov.boocarep.service.employee.EmployeeService;
import com.bozhilov.boocarep.service.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
   private final UserService userService;
   private final EmployeeService employeeService;

   public UniqueUsernameValidator(UserService userService, EmployeeService employeeService) {
      this.userService = userService;
      this.employeeService = employeeService;
   }

   public boolean isValid(String username, ConstraintValidatorContext context) {
      return this.userService.findUserByUsername(username) == null &&
              this.employeeService.findEmployeeByUsername(username)==null;
   }
}
