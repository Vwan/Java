package com.rest.common;

import java.util.logging.Logger;
public class Log {

	protected Logger log = Logger.getLogger("com.hp.rest");
     /**
     * @param args
     */
    public void info(String message) {
        log.info(message);
    }
    
    public void error(String message) {
        log.info(message);
    }
    
    public Log instance(){
    	if (log==null){
    		return new Log();
    	}
    	else return null;
    }
}
