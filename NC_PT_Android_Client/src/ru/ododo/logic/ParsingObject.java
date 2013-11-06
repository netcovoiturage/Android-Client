package ru.ododo.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParsingObject {
	
	public static String getVkUserId(String url){
		String [] strArr=url.split("user_id=");
		return strArr[1];
		
	}
	
	public static String getFirstLastName(String jsonStr){
		String [] resArr=null;
		try {
			JSONObject jsonObj=new JSONObject(jsonStr);
			JSONArray person=jsonObj.getJSONArray(Settings.TAG_RESPONSE);
			resArr=new String[2];
			for(int i=0;i<person.length();i++){
				JSONObject node=person.getJSONObject(i);
				resArr[0]=node.getString(Settings.TAG_FIRST_NAME);
				resArr[1]=node.getString(Settings.TAG_LAST_NAME);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		StringBuilder fullName=new StringBuilder(resArr[0]+" ");
		fullName.append(resArr[1]);
		return fullName.toString();
	}

}
