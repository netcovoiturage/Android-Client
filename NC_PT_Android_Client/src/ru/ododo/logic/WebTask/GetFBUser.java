package ru.ododo.logic.WebTask;

import ru.ododo.activities.SocialNetworkAuth;
import ru.ododo.logic.Settings;
import ru.ododo.logic.SocNetAbstractFactory.FBConnect;
import android.os.AsyncTask;
import android.util.Log;

import com.facebook.*;
import com.facebook.model.*;

public class GetFBUser extends AsyncTask<Void, Void, Void> {

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		Log.d(Settings.MY_TAG, "onPreExecute");
	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		if(SocialNetworkAuth.getAct()!=null){
		Session.openActiveSession(SocialNetworkAuth.getAct(), 
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
		else{
			Log.d(Settings.MY_TAG, "activity is null");
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		SocialNetworkAuth.finishActivitySocialNetworkAuth();
	}

}
