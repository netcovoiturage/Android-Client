package ru.ododo.logic;

//constants
public class Settings {
	public final static String VK_AUTH_URL="https://oauth.vk.com/authorize?";
	//application id
	public final static String VK_CLINT_ID="client_id=3955910&";
	//redirect to site
	public final static String VK_REDIRECT_URL="edirect_uri=https://oauth.vk.com/blank.htm&";
	//access application setting 
	public final static String VK_SCOPE="scope=offline&";
	//type of our display
	public final static String VK_DISPLAY="display=mobile&";
	//type of response from server
	public final static String VK_RESPONSE_TYPE="response_type=token";
	
	//for LogCat
	public final static String MY_TAG="TAG";
	
	//key for intent
	public final static String NAME_OF_SOCIAL_NETWORK="ru.ododo.android.client.SOCIALNETWORK";
	
	//status
	public final static int STATUS_SUCCESS=200;
	public final static int STATUS_FAILED=400;
	
	//key for SharedPreferences files
	public final static String VK_USER_ID="vk_user_id";
	
}
