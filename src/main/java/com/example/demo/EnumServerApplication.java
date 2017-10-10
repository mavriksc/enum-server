package com.example.demo;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;

@SpringBootApplication
public class EnumServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnumServerApplication.class, args);
	}
}
enum States{
    STATE_ONE,STATE_TWO,STATE_THREE; 
//    @JsonValue
//    public int toValue() {
//        return ordinal();
//    }
}

class IHaveStates{
    States state;
    
    public States getState() {
        return state;
    }  

    public IHaveStates() {
        state = States.values()[ThreadLocalRandom.current().nextInt(3)];
    }
}
@CrossOrigin
@RestController
class EnumServer{
    @RequestMapping("/")
    IHaveStates getObject() {
        return new IHaveStates();
    }
    
}
