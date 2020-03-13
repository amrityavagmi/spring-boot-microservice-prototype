package com.intuit.services;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public int findSquare(int num) {
        return num*num;
    }
}
