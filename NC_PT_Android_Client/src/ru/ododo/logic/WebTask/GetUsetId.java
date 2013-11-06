package ru.ododo.logic.WebTask;



import ru.ododo.activities.SocialNetworkAuth;
import ru.ododo.logic.ParsingObject;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.webkit.WebView;

public class GetUsetId extends AsyncTask<Void, Void, String> {

	WebView webview;
	ProgressDialog pb;
	String userId;
	String urlWithToken;
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		webview.setVisibility(WebView.INVISIBLE);
		pb.setMessage("Please wait");
		pb.show();
	}

	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		userId=ParsingObject.getVkUserId(SocialNetworkAuth.getUrlWithAccessToken());
		return userId;
	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		pb.cancel();
	}
	
	public GetUsetId(){
		this.pb=SocialNetworkAuth.getPb();
		this.webview=SocialNetworkAuth.getWebview();
		this.urlWithToken=SocialNetworkAuth.getUrlWithAccessToken();
	}

}
