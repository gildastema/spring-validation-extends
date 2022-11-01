package com.gildastema.validations.Features;

import com.gildastema.validations.supports.MatchRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;


public class MatchTest extends AbstractIntegration{

    @Test
    public void verifyMatchOK(){
        final ResponseEntity<Object> response = postJson( "/api/match", new MatchRequest("123456789", "123456789") );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void verifyMachFailed(){
        ResponseEntity<Object> response = postJson("/api/match", new MatchRequest("123456789", "1234567"));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
