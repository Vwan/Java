package com.rest.common;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LogBack{

	protected Logger logger = LoggerFactory.getLogger(getClass());
     /**
     * @param args
     */
    public void info(String message) {
        logger.info(message);
    }
}
