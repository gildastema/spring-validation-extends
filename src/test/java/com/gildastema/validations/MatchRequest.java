package com.gildastema.validations;

import com.gildastema.validations.constraints.Match;

@Match(field = "password", confirmation = "passwordConfirmation")
public class MatchRequest {
     private   String password;
     private String passwordConfirmation;


    public MatchRequest(){

    }

    public MatchRequest(String password, String passwordConfirmation) {
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation){
        this.passwordConfirmation = passwordConfirmation;
    }
}
