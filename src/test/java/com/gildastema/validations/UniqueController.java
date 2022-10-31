package com.gildastema.validations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UniqueController {

    @PostMapping("/api/unique")
    public void unique(@Valid @RequestBody UniqueRequest uniqueRequest){

    }
}
