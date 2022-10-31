package com.gildastema.validations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class MatchTest {

    @LocalServerPort
    private int localPort;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void verifyMatchOK(){
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String baseUrl = "http://localhost:"+localPort+"/api/match";
        final HttpEntity  request = new HttpEntity(new MatchRequest("123456789", "123456789"), headers );
        ResponseEntity<Object> response = restTemplate.postForEntity(baseUrl, request, null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void verifyMachFailed(){
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String baseUrl = "http://localhost:"+localPort+"/api/match";
        final HttpEntity  request = new HttpEntity(new MatchRequest("123456789", "1234567"), headers );
        ResponseEntity<Object> response = restTemplate.postForEntity(baseUrl, request, null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
