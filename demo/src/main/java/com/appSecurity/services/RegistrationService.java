package com.appSecurity.services;

import com.appSecurity.models.Person;
import com.appSecurity.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

        public Optional<Person> getPersonByUsername (String username){
            return peopleRepository.findPersonByUsername(username);
        }

        @Transactional
        public void register (Person person){
            peopleRepository.save(person);
        }
}
