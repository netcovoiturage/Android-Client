package ru.ododo.activities;




import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import ru.ododo.logic.Settings;
import ru.ododo.logic.WebTask.GetUsetId;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class SocialNetworkAuth extends Activity {

	static String SocialNetwork;
	WebView webview;
	ProgressDialog pb;
	Intent intent;
	Handler checkUrl;
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
								newTask=new GetUsetId(webview,pb,SocialNetworkAuth.this);
								newTask.execute(url);
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
	public void saveUserId(String id){
		SharedPreferences shrId=getSharedPreferences(Settings.VK_USER_ID, MODE_PRIVATE);;
		Editor ed=shrId.edit();
		ed.putString(Settings.VK_USER_ID, id+SocialNetwork);
		ed.commit();
	}
	public String loadUserId(){
		SharedPreferences shrId=getSharedPreferences(Settings.VK_USER_ID, MODE_PRIVATE);
		String id=shrId.getString(Settings.VK_USER_ID, "");
		return id;
	}
	public void finishSocialNetworkAuth(){
		Intent intent=new Intent();
		if(loadUserId().equalsIgnoreCase("")){
			intent.putExtra("get_id", Settings.STATUS_FAILED);
		}
		else{
			intent.putExtra("get_id", Settings.STATUS_SUCCESS);
		}
		setResult(RESULT_OK,intent);
		finish();
	}
}
