package com.demo.numberconverter.controllers;

import com.demo.numberconverter.enums.Format;
import com.demo.numberconverter.services.AuditService;
import com.demo.numberconverter.services.ConverterService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
public class ConverterController {

    private static final String INVALID_MESSAGE = "Invalid format";

    private ConverterService converterService;
    private AuditService auditService;

    public ConverterController(@NotNull ConverterService converterService,
                               @NotNull AuditService auditService) {
        this.converterService = converterService;
        this.auditService = auditService;
    }

    @CrossOrigin
    @GetMapping(path = "/convert/{format}")
    public String getRomanConversion(@PathVariable(name = "format") String format,
                                     @RequestParam(value = "value") long numValue) {
        String result = INVALID_MESSAGE;

        if (format == null || format.matches(Format.DECIMAL.getCompleteName())) {
            result = this.converterService.convertDecimalToRoman(numValue);

        } else if (format.matches(Format.BINARY.getCompleteName())) {
            result = this.converterService.convertBinaryToRoman(numValue);
        }
        auditService.logConversionRequest(numValue, format, result);
        return result;
    }
}
