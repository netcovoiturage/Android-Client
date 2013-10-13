package ru.ododo.logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class EnterBySocialNetwork extends Activity{
	
	final static String MY_TAG="myTag";
	
	static String url;
	static String SocialNetwork;
	private static String VK_PREF_TOKEN="vk_token";
	private SharedPreferences tPref;
	
	//заходим в систему
	public void enterInSystem(WebView webview, String nameOfSocialNetwork){
		SocialNetwork=nameOfSocialNetwork;
		if(SocialNetwork.equalsIgnoreCase("_VK")){
			enterByVk(webview);
		}
	}
	
	private void enterByVk(WebView webview){
	
		tPref=getPreferences(MODE_PRIVATE);
		String vk_token=tPref.getString(VK_PREF_TOKEN, "");
		Log.d(MY_TAG, "token:"+vk_token);
		if(vk_token.length()==0){
			
			Log.d(MY_TAG, "browser create");
	        webview.setVerticalScrollBarEnabled(false);
	        webview.setHorizontalScrollBarEnabled(false);
	        webview.clearCache(true);
	        url=Settings.VK_AUTH_URL+Settings.VK_CLINT_ID+Settings.VK_REDIRECT_URL+Settings.VK_SCOPE+
	        		Settings.VK_DISPLAY+Settings.VK_RESPONSE_TYPE;
	        webview.loadUrl(url);
	        webview.setVisibility(View.VISIBLE);
	        String JSONUrl=getJSON();
	        Log.d(MY_TAG, "JSON:"+JSONUrl);
	        
		}
		
	}
	
	/*private void enterByFb(){
		
	}*/
	private String getJSON(){
		DefaultHttpClient   httpclient = new DefaultHttpClient(new BasicHttpParams());
		HttpPost httppost = new HttpPost("https://oauth.vk.com/blank.html");
		httppost.setHeader("Content-type", "application/json");
		InputStream inputStream = null;
		String result = null;
		try {
		    HttpResponse response = httpclient.execute(httppost);           
		    HttpEntity entity = response.getEntity();

		    inputStream = entity.getContent();
		    // json is UTF-8 by default
		    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
		    StringBuilder sb = new StringBuilder();

		    String line = null;
		    while ((line = reader.readLine()) != null)
		    {
		        sb.append(line + "\n");
		    }
		    result = sb.toString();
		} catch (Exception e) { 
		    // Oops
		}
		finally {
		    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
		}
		return result;
	}
	private void parsingJSON(String JSONStr){
		
	}
}


