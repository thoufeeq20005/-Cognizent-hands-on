package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {

    private static final Logger logger =
            LogManager.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARNING message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");
    }
}