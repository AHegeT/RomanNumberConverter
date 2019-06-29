package com.demo.numberconverter.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConverterServiceTest {

    static private final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    static private final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static private final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static private final String[] UNITS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    @InjectMocks
    ConverterService converterService;

    @Test
    public void testConvertLessThanFourThousand() {
        for (int i = 1; i < 4; i++) {
            String result = converterService.convertNumberToRoman((i) * 1000);
            assertEquals(THOUSANDS[i], result);
        }
    }

    @Test
    public void testConvertLessThanOneThousand() {
        for (int i = 1; i < 9; i++) {
            String result = converterService.convertNumberToRoman((i) * 100);
            assertEquals(HUNDREDS[i], result);
        }
    }

    @Test
    public void testConvertLessThanOneHundred() {
        for (int i = 1; i < 9; i++) {
            String result = converterService.convertNumberToRoman((i) * 10);
            assertEquals(TENS[i], result);
        }
    }

    @Test
    public void testConvertLessThanTen() {
        for (int i = 0; i < 9; i++) {
            String result = converterService.convertNumberToRoman(i + 1);
            assertEquals(UNITS[i], result);
        }
    }

    @Test
    public void testConvertInvalidBounds() {
        String invalidMessage = "Invalid number";

        String result = converterService.convertNumberToRoman(-1);
        assertEquals(invalidMessage, result);

        result = converterService.convertNumberToRoman(0);
        assertEquals(invalidMessage, result);

        result = converterService.convertNumberToRoman(4000);
        assertEquals(invalidMessage, result);
    }

    @Test
    public void testConvertBinaryToDecimal() {
        int result = converterService.convertBinaryToDecimal(0001);
        assertEquals(1, result);

        result = converterService.convertBinaryToDecimal(1000);
        assertEquals(8, result);

        result = converterService.convertBinaryToDecimal(1001);
        assertEquals(9, result);

        result = converterService.convertBinaryToDecimal(1111);
        assertEquals(15, result);
    }

}