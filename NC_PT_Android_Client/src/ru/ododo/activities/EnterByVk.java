package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import ru.ododo.logic.ParsingObject;
import ru.ododo.logic.Variables;
import ru.ododo.logic.SocNetAbstractFactory.VK;
import ru.ododo.logic.systemstate.SysSinglton;
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




public class EnterByVk extends Activity {

	static String SocialNetwork;
	static WebView webview;
	static ProgressDialog pb;
	static EnterByVk act;
	static String urlWithAccessToken;
	
	public static WebView getWebview() {
		return webview;
	}
	public static void setWebview(WebView webview) {
		EnterByVk.webview = webview;
	}
	public static ProgressDialog getPb() {
		return pb;
	}
	public static void setPb(ProgressDialog pb) {
		EnterByVk.pb = pb;
	}
	public static EnterByVk getAct() {
		return act;
	}
	public static void setAct(EnterByVk act) {
		EnterByVk.act = act;
	}
	public static String getUrlWithAccessToken() {
		return urlWithAccessToken;
	}
	public static void setUrlWithAccessToken(String urlWithAccessToken) {
		EnterByVk.urlWithAccessToken = urlWithAccessToken;
	}
	Intent intent;
	Handler checkUrl;
	Handler fbHandler;
	Thread thForHandl;

	
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("Enter by vk");
		setContentView(R.layout.social_network_auth);
		
		intent=getIntent();
		SocialNetwork=intent.getStringExtra(Variables.NAME_OF_SOCIAL_NETWORK);
		webview=(WebView)findViewById(id.webBr_for_social);
		pb=new ProgressDialog(this);
		act=this;
		Log.d(Variables.MY_TAG, "socNet name:"+SocialNetwork);
		
			String url=Variables.VK_AUTH_URL+Variables.VK_CLINT_ID+Variables.VK_REDIRECT_URL+Variables.VK_SCOPE+
	        		Variables.VK_DISPLAY+Variables.VK_RESPONSE_TYPE;
			
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
							public void onLoadResource(WebView view, String url) {
								// TODO Auto-generated method stub
								super.onLoadResource(view, url);
								pb.setMessage("Loading");
								pb.setCanceledOnTouchOutside(false);
								pb.show();
							}
							@Override
							public void onPageFinished(WebView view, String url) {
								// TODO Auto-generated method stub
								super.onPageFinished(view, url);
								pb.cancel();
							}
							
							@Override
							public boolean shouldOverrideUrlLoading(WebView view,
									String url) {
								// TODO Auto-generated method stub
								if(url.contains("access_token")){
									Log.d(Variables.MY_TAG, "URL:"+url);
									VK.setUserID(ParsingObject.getVkUserId(url));
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
					Log.d(Variables.MY_TAG, "Start URL:"+url);
					webview.loadUrl(url);
					

			
		}
	public void startNewActivity(){
		Log.d(Variables.MY_TAG, "startNewActivAfterWeGetName");
		this.setVisible(false);
		Intent intent=new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
