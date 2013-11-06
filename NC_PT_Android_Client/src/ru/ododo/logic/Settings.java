package ru.ododo.logic;

//constants
public class Settings {
	public final static String VK_AUTH_URL="https://oauth.vk.com/authorize?";
	//application id
	public final static String VK_CLINT_ID="client_id=3969155&";
	//redirect to site
	public final static String VK_REDIRECT_URL="edirect_uri=https://oauth.vk.com/blank.htm&";
	//access application setting 
	public final static String VK_SCOPE="scope=offline&";
	//type of our display
	public final static String VK_DISPLAY="display=mobile&";
	//type of response from server
	public final static String VK_RESPONSE_TYPE="response_type=token";
	
	//API parameters
	public final static String VK_API_ADDRESS="https://api.vk.com/method/";
	public final static String VK_API_METHOD_NAME="users.get?";
	public final static String VK_API_USER_ID="user_id=";//this string require id from shared file
	public final static String VK_API_LANG="&lang=en";
	
	//for LogCat
	public final static String MY_TAG="TAG";
	
	//key for intent
	public final static String NAME_OF_SOCIAL_NETWORK="ru.ododo.android.client.SOCIALNETWORK";
	
	//status
	public final static int STATUS_SUCCESS=200;
	public final static int STATUS_FAILED=400;
	
	//key for SharedPreferences files
	public final static String SHARERD_FILE_KEY="shared_key";
	
	//key for Shared values
	public final static String VK_SHARED_FILE_ID="vk_user_id";
	public final static String FIRST_NAME="first_name";
	public final static String LAST_NAME="last_name";
	
	// JSON Node names
	public final static String TAG_RESPONSE="response";
	public final static String TAG_FIRST_NAME="first_name";
	public final static String TAG_LAST_NAME="last_name";
	
}
