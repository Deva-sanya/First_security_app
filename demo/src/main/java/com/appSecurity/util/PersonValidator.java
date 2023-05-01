package com.appSecurity.util;

import com.appSecurity.models.Person;
import com.appSecurity.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final RegistrationService registrationService;

    @Autowired
    public PersonValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (registrationService.getPersonByUsername(person.getUsername()).isPresent())
        errors.rejectValue("username", "", "Person with this username already exists");
    }
}
