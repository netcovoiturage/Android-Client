package ru.ododo.logic;


public class ParsingObject {
	
	public static String getVkUserId(String url){
		String [] strArr=url.split("user_id=");	
		return strArr[1];
	}

}
