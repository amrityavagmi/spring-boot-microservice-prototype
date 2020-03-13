package com.intuit.controllers;

import com.intuit.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/square/{number}")
    public int findSquare(@PathVariable("number") int num) {
        return numberService.findSquare(num);
    }
}
