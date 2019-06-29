package com.demo.numberconverter.controllers;

import com.demo.numberconverter.enums.Format;
import com.demo.numberconverter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConverterController {

    @Autowired
    ConverterService converterService;

    static final String INVALID_MESSAGE = "Invalid format";

    @GetMapping(path = "/convert")
    public String getRomanConversion(@RequestParam(value = "initialValue") int numValue,
                                     @RequestParam(value = "format") String format) {
        if (format == null || format.matches(Format.DECIMAL.getSimpleName())) {
            return this.converterService.convertDecimalToRoman(numValue);
        } else if (format.matches(Format.BINARY.getSimpleName())) {
            return this.converterService.convertBinaryToRoman(numValue);
        }
        // TODO: Create a Custom Exception
        return INVALID_MESSAGE;
    }
}
