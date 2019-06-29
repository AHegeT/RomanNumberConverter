package com.demo.numberconverter.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterServiceTest {

    ConverterService converterService;

    @Test
    public void convertNumber() {
        String r = converterService.convertNumber(1);
        assertEquals(r, "");
    }

}