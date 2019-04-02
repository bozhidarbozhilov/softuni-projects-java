package com.bozhilov.boocarep.domain.annotations;

import com.bozhilov.boocarep.service.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
   private final UserService userService;

   public UniquePhoneNumberValidator(UserService userService) {
      this.userService = userService;
   }

   public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
      return this.userService.findUserByPhoneNumber(phoneNumber) == null;
   }
}
