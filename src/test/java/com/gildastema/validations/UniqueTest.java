package com.gildastema.validations;

import com.gildastema.validations.supports.Person;
import com.gildastema.validations.supports.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueTest  extends AbstractIntegration{

    @Autowired
    private PersonRepository personRepository;



    @Test
    public void uniqueCatch(){
        // prepare
        String email = "gildastema3@gmail.com";
        Person person = personRepository.save(new Person(email));
        // act
        final ResponseEntity<Object> response = postJson("/api/unique", new UniqueRequest(email));
        //verify
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    }

    @Test
    public void uniquePass(){
        // prepare
        String email = "gildastema3@gmail.com";
        Person person = personRepository.save(new Person(email));
        // act
        final ResponseEntity<Object> response = postJson("/api/unique", new UniqueRequest("hello@gmail.com"));
        //verify
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
