package org.saurabhsood.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
   public void initialize(Phone constraint) {
   }

   public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
      if (phoneNo == null) {
         return false;
      }
      return phoneNo.matches("\\d{10}");
   }
}
