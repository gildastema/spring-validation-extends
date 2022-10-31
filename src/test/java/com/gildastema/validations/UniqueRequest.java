package com.gildastema.validations;

import com.gildastema.validations.constraints.Unique;

public class UniqueRequest {
    @Unique(field = "email", table = "persons")
    private String email;

    public UniqueRequest(){

    }

    public UniqueRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
