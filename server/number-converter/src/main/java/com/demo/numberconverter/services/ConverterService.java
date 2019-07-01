package com.demo.numberconverter.services;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    static final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static final String[] UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    static final String INVALID_NUMBER_MESSAGE = "Invalid number";

    public String convertDecimalToRoman(long numValue) {
        if (numValue < Integer.MIN_VALUE || numValue > Integer.MAX_VALUE) {
            return INVALID_NUMBER_MESSAGE;
        }
        return convertNumberToRoman((int) numValue);
    }

    public String convertBinaryToRoman(long binaryValue) {
        int decimalValue = convertBinaryToDecimal(binaryValue);
        return convertNumberToRoman(decimalValue);
    }

    public int convertBinaryToDecimal(long binaryValue) {
        if (binaryValue > 111110100000L) {
            return 4000;
        }
        int decimalValue = 0;
        int base = 1;

        long r = binaryValue;
        while (r > 0) {
            long lastDigit = r % 10;
            r /= 10;

            decimalValue += lastDigit * base;

            base *= 2;
        }
        return decimalValue;
    }

    public String convertNumberToRoman(int numValue) {
        if (numValue < 1 || numValue > 3999) {
            return(INVALID_NUMBER_MESSAGE);
        }

        return new StringBuilder()
                .append(THOUSANDS[numValue / 1000])
                .append(HUNDREDS[numValue % 1000 / 100])
                .append(TENS[numValue % 100 / 10])
                .append(UNITS[numValue % 10])
                .toString();
    }

}
