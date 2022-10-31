# Spring Validation Extends
The `spring-validation-extends` package provides easy to use constraints to extends validations. By adding new validations
examples: unique, matches etc.

[![GitHub](https://github.com/gildastema/spring-validation-extends/actions/workflows/test.yml/badge.svg)](https://github.com/gildastema/spring-validation-extends/actions/workflows/test.yml)
[![](https://jitpack.io/v/gildastema/spring-validation-extends.svg)](https://jitpack.io/#gildastema/spring-validation-extends)

## Installation 
    - Gradle 
```groovy
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
    implementation 'com.github.gildastema:spring-validation-extends:Tag'
}
```

    - Maven 

````xml
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
</repositories>

<dependency>
    <groupId>com.github.gildastema</groupId>
    <artifactId>spring-validation-extends</artifactId>
    <version>Tag</version>
</dependency>
````

## Usage

    - Match 
This decorator is use to ensure two values is same a common usage it is a  password confirmarion.

```java

// Request class

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

// controller class

    @PostMapping("api/match")
    public void match(@Valid @RequestBody MatchRequest matchRequest){

    }
```

    - Unique
This one is use to ensure that one value is already exist in database like an email.

```java
// class request

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

```