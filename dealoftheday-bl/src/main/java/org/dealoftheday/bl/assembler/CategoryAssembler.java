package org.dealoftheday.bl.assembler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Category;

public class CategoryAssembler {
	
	private static Logger logger = LogManager.getLogger(CategoryAssembler.class);
	
	 public static Category getEnum(String categoryAsString){
	    	if(categoryAsString == null) {
	    		return null;
	    	}
	        return Category.valueOf(categoryAsString);
	    }
	    
	    public static String getString(Category categoryAsEnum){
	    	if(categoryAsEnum == null) {
	    		return null;
	    	}
	        return categoryAsEnum.toString();
	    }

}
