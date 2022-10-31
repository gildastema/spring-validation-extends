package com.gildastema.validations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MatchController {


    @PostMapping("api/match")
    public void match(@Valid @RequestBody MatchRequest matchRequest){

    }

}
