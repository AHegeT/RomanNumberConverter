package com.demo.numberconverter.services;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    static final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static final String[] UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String convertDecimalToRoman(int numValue) {
        return convertNumberToRoman(numValue);
    }

    public String convertBinaryToRoman(int numValue) {
        return convertNumberToRoman(numValue);
    }

    public String convertNumberToRoman(int numValue) {
        if (numValue < 1 || numValue > 3999) {
            return("Invalid input");
        }

        return new StringBuilder()
                .append(THOUSANDS[numValue / 1000])
                .append(HUNDREDS[numValue % 1000 / 100])
                .append(TENS[numValue % 100 / 10])
                .append(UNITS[numValue % 10])
                .toString();
    }

}
