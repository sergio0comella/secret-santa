package it.panezio.secretsanta.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

}
