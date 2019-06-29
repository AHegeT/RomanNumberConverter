package com.demo.numberconverter.services;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public String convertDecimal(int numValue) {
        convertNumber(numValue);
        return "";
    }

    public String convertNumber(int numValue) {
        return "";
    }

}
