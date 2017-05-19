package com.personal.demo.annotation.validator;

import com.personal.demo.annotation.PasswordMatches;
import com.personal.demo.domain.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Chema on 18/05/2017.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation){
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto)obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
