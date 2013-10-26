package ru.ododo.logic.WebTask;



import ru.ododo.activities.SocialNetworkAuth;
import ru.ododo.logic.ParsingObject;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.webkit.WebView;

public class GetUsetId extends AsyncTask<String, Void, Void> {

	WebView webview;
	ProgressDialog pb;
	String userId;
	SocialNetworkAuth act;
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		webview.setVisibility(WebView.INVISIBLE);
		pb.setMessage("Please wait");
		pb.show();
		
	}

	@Override
	protected Void doInBackground(String... url) {
		// TODO Auto-generated method stub
		if(url[0].contains("access_token")){
			userId=ParsingObject.getVkUserId(url[0]);
			act.saveUserId(userId);
		}
		else{
		}
		return null;
	}

	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		pb.cancel();
		act.finishSocialNetworkAuth();
	}
	
	public GetUsetId(WebView webview,ProgressDialog pb,SocialNetworkAuth a){
		this.pb=pb;
		this.webview=webview;
		this.act=a;
	}

}
