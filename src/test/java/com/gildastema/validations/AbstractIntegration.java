package com.gildastema.validations;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
      properties = {
              "spring.jpa.hibernate.ddl-auto=create-drop",
              "spring.jpa.show-sql = true"
      }
)
@AutoConfigureTestDatabase
public class AbstractIntegration {

      @LocalServerPort
      private int localPort;

      @Autowired
      protected TestRestTemplate restTemplate;

      protected String getUrl(String path){
            return "http://localhost:"+localPort+""+path;
      }

      protected ResponseEntity<Object> postJson(String url ,  Object request){
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            final String baseUrl = getUrl(url);
            final HttpEntity httpEntity = new HttpEntity( request, headers );
            return restTemplate.postForEntity(baseUrl, request, null);
      }
}
