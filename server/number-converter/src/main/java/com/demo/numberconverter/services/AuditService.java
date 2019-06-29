package com.demo.numberconverter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuditService {

    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);

    public void logConversionRequest(long requestedValue, String requestedFormat, String requestResult) {
        String message = String
                .format("%s -- Converting value %d to %s. Resulted in: %s",
                        Instant.now().toString(), requestedValue, requestedFormat, requestResult);
        logger.info(message);
    }

}
