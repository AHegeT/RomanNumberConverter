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

    @CrossOrigin
    @GetMapping(path = "/convert/{format}")
    public String getRomanConversion(@PathVariable(name = "format") String format,
                                     @RequestParam(value = "value") int numValue) {

        if (format == null || format.matches(Format.DECIMAL.getSimpleName())) {
            return this.converterService.convertDecimalToRoman(numValue);

        } else if (format.matches(Format.BINARY.getSimpleName())) {
            return this.converterService.convertBinaryToRoman(numValue);
        }
        return INVALID_MESSAGE;
    }
}
