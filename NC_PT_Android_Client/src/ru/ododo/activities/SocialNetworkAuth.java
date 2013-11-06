package ru.ododo.activities;





import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import ru.ododo.logic.Settings;
import ru.ododo.logic.SocNetAbstractFactory.FBConnect;
import ru.ododo.logic.SocNetAbstractFactory.VK;
import ru.ododo.logic.SystemState.SysSinglton;
import ru.ododo.logic.WebTask.GetUsetId;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class SocialNetworkAuth extends Activity {

	static String SocialNetwork;
	static WebView webview;
	static ProgressDialog pb;
	static SocialNetworkAuth act;
	static String urlWithAccessToken;
	
	public static WebView getWebview() {
		return webview;
	}
	public static void setWebview(WebView webview) {
		SocialNetworkAuth.webview = webview;
	}
	public static ProgressDialog getPb() {
		return pb;
	}
	public static void setPb(ProgressDialog pb) {
		SocialNetworkAuth.pb = pb;
	}
	public static SocialNetworkAuth getAct() {
		return act;
	}
	public static void setAct(SocialNetworkAuth act) {
		SocialNetworkAuth.act = act;
	}
	public static String getUrlWithAccessToken() {
		return urlWithAccessToken;
	}
	public static void setUrlWithAccessToken(String urlWithAccessToken) {
		SocialNetworkAuth.urlWithAccessToken = urlWithAccessToken;
	}
	Intent intent;
	Handler checkUrl;
	Handler fbHandler;
	Thread thForHandl;
	GetUsetId newTask;
	
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setTitle("Enter by social network:");
		setContentView(R.layout.social_network_auth);
		
		intent=getIntent();
		SocialNetwork=intent.getStringExtra(Settings.NAME_OF_SOCIAL_NETWORK);
		webview=(WebView)findViewById(id.webBr_for_social);
		pb=new ProgressDialog(this);
		act=SocialNetworkAuth.this;
		Log.d(Settings.MY_TAG, "socNet name:"+SocialNetwork);
		
		if(SocialNetwork.equalsIgnoreCase("_VK")){
			String url=Settings.VK_AUTH_URL+Settings.VK_CLINT_ID+Settings.VK_REDIRECT_URL+Settings.VK_SCOPE+
	        		Settings.VK_DISPLAY+Settings.VK_RESPONSE_TYPE;
			
			webview.setVerticalScrollBarEnabled(false);
			webview.setHorizontalScrollBarEnabled(false);
			webview.clearCache(true);
			checkUrl=new Handler(){
	
					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						super.handleMessage(msg);
						webview.setWebViewClient(new WebViewClient(){
	
							@Override
							public boolean shouldOverrideUrlLoading(WebView view,
									String url) {
								// TODO Auto-generated method stub
								if(url.contains("access_token")){
									Log.d(Settings.MY_TAG, "try create user");
									urlWithAccessToken=url;
									SysSinglton.getInstance().createUser(new VK());
								}
								return false;
							}
							
						});
				
					}
				
				};
				thForHandl=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						checkUrl.sendEmptyMessage(0);	
					}
					
				});
					thForHandl.start();			
					webview.loadUrl(url);
			}
			else{
				Log.d(Settings.MY_TAG, "try create fb user");
				//SysSinglton.getInstance().createUser(new FB());
				Session.openActiveSession(this, 
						true, new Session.StatusCallback() {
							
							@Override
							public void call(Session session, SessionState state, Exception exception) {
								// TODO Auto-generated method stub
								Log.d(Settings.MY_TAG, "call");
								if(session.isOpened()){
									Request.newMeRequest(session, new Request.GraphUserCallback() {
										
										@Override
										public void onCompleted(GraphUser user, Response response) {
											// TODO Auto-generated method stub
											if(user!=null){
												Log.d(Settings.MY_TAG, "Name: "+user.getName());
												FBConnect.setUser(user);
											}
											else{
												Log.d(Settings.MY_TAG, "user is null");
											}
											
										}
									}).executeAsync();
								}
								
							}
						});
			}
		}
	/*public void saveUserId(String id){
		SharedPreferences shrId=getSharedPreferences(Settings.SHARERD_FILE_KEY, MODE_PRIVATE);;
		Editor ed=shrId.edit();
		ed.putString(Settings.VK_SHARED_FILE_ID, id+SocialNetwork);
		ed.commit();
	}
	public String loadUserId(){
		SharedPreferences shrId=getSharedPreferences(Settings.SHARERD_FILE_KEY, MODE_PRIVATE);
		String id=shrId.getString(Settings.VK_SHARED_FILE_ID, "");
		return id;
	}*/
	public static void finishActivitySocialNetworkAuth(){
		Intent intent=new Intent();
		intent.putExtra("get_id", Settings.STATUS_SUCCESS);
		act.setResult(RESULT_OK,intent);
		act.finish();
	}
}
