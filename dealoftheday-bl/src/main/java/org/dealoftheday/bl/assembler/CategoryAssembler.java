package org.dealoftheday.bl.assembler;

import org.dealoftheday.bl.domain.Category;

public class CategoryAssembler {
	
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
