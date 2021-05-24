package org.dealoftheday.bl.assembler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Status;

public class StatusAssembler {
	
	private static Logger logger = LogManager.getLogger(StatusAssembler.class);
	
	 public static Status getEnum(String statusAsString){
	    	if(statusAsString == null) {
	    		return null;
	    	}
	        return Status.valueOf(statusAsString);
	    }
	    
	    public static String getString(Status statusAsEnum){
	    	if(statusAsEnum == null) {
	    		return null;
	    	}
	        return statusAsEnum.toString();
	    }

}
