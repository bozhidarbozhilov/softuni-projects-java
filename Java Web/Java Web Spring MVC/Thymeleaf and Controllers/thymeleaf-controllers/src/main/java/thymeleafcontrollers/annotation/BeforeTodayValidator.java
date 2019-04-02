package thymeleafcontrollers.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

public class BeforeTodayValidator implements ConstraintValidator<BeforeToday, Date> {
   public void initialize(BeforeToday constraint) {
   }

   public boolean isValid(Date date, ConstraintValidatorContext context) {
      return date.before(new Date());
   }
}
