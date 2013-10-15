package ru.ododo.activities;

import ru.ododo.logic.Settings;
import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;



public class SocialNetworkAuth extends Activity {
	final static String MY_TAG="myTag";
	
	static String url;
	static String SocialNetwork;
	private static String VK_PREF_TOKEN="vk_token";
	private SharedPreferences tPref;
	WebView webview;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("Быстрый вход");
		setContentView(R.layout.social_network_auth);
		
		tPref=getPreferences(MODE_PRIVATE);
		String vk_token=tPref.getString(VK_PREF_TOKEN, "");
		if(vk_token.length()==0){
			webview=(WebView)findViewById(id.webBr_for_social);
	        webview.setVerticalScrollBarEnabled(false);
	        webview.setHorizontalScrollBarEnabled(false);
	        webview.clearCache(true);
	        url=Settings.VK_AUTH_URL+Settings.VK_CLINT_ID+Settings.VK_REDIRECT_URL+Settings.VK_SCOPE+
	        		Settings.VK_DISPLAY+Settings.VK_RESPONSE_TYPE;
	        webview.loadUrl(url);
	        webview.setVisibility(View.VISIBLE);
	        
			}
		}

}
