package com.intuit.numbersquareui.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.spec.PSource;

@RestController
@RequestMapping("/math")
public class MathController {

    @Value("${square.service.base.url}")
    private String squareServiceBaseURL;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/square/{number}")
    @HystrixCommand(fallbackMethod = "computeSquareFallBack")
    public String getSquare(@PathVariable("number") int num) {
        System.out.println("**********in compute square method");
        String uri = squareServiceBaseURL + num;
        ResponseEntity<Integer> response = restTemplate.getForEntity(uri,Integer.class);
        return "square of " + num + " is " + response.getBody();
    }

    public String computeSquareFallBack(int num) {
        System.out.println("**********in compute square fallback method");
        return "Oops!! service is down. Please try later";
    }
}
