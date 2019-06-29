package com.demo.numberconverter.controllers;

import com.demo.numberconverter.enums.Format;
import com.demo.numberconverter.services.AuditService;
import com.demo.numberconverter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ConverterController {

    @Autowired
    ConverterService converterService;
    @Autowired
    AuditService auditService;

    static private final String INVALID_MESSAGE = "Invalid format";

    @CrossOrigin
    @GetMapping(path = "/convert/{format}")
    public String getRomanConversion(@PathVariable(name = "format") String format,
                                     @RequestParam(value = "value") long numValue) {

        auditService.logConversionRequest(numValue, format);
        if (format == null || format.matches(Format.DECIMAL.getCompleteName())) {
            String result = this.converterService.convertDecimalToRoman(numValue);
            auditService.logConversionResult(numValue, format, result);
            return result;

        } else if (format.matches(Format.BINARY.getCompleteName())) {
            String result = this.converterService.convertBinaryToRoman(numValue);
            auditService.logConversionResult(numValue, format, result);
            return result;
        }
        return INVALID_MESSAGE;
    }
}
