package com.demo.numberconverter.controllers;

import com.demo.numberconverter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @Autowired
    ConverterService converterService;

    @RequestMapping(path = "/convert", method = RequestMethod.GET)
    public String getRomanConversion(@RequestParam(value = "initialValue") int numValue,
                                     @RequestParam(value = "format") String format) {
        if (format != null) {
            return this.converterService.convertDecimal(numValue);
        }
        // TODO: Create a Custom Exception
        return "Invalid Format";
    }
}
