package com.demo.numberconverter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Instant;

@Service
public class AuditService {

    private static final String LOG_FILE = "./audit/conversions.log";
    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);

    /**
     * Logs the petition and result of a conversion, successful or not.
     * @param requestedValue value to convert
     * @param requestedFormat format to convert from
     * @param requestResult successful conversion result or error message
     */
    public void logConversionRequest(long requestedValue, String requestedFormat, String requestResult) {
        String message = String
                .format("%s | %d | %s | %s %n",
                        Instant.now().toString(), requestedValue, requestedFormat, requestResult);

        log(message);
    }

    /**
     * Logs a message into the audit file
     * @param message formatted message to log in file
     */
    private void log(String message) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
