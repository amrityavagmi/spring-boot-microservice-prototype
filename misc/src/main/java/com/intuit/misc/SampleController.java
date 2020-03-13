package com.intuit.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@RestController
public class SampleController {

    static Logger log = LoggerFactory.getLogger(SampleController.class);

    @PostMapping("/dummy")
    public String doSomethingSilly() {
        int num=1/0;
        return "Cool";
    }
    @Value("${welcome}")
    private String message;

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException aex, WebRequest wreq) {
        String message = "ERROR :" + aex.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping
    public String hi() {
        log.info("hello");
        return message;
    }
}
