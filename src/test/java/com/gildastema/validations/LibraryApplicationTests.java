package com.gildastema.validations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SpringBootApplication

class LibraryApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplicationTests.class, args);
    }


}


