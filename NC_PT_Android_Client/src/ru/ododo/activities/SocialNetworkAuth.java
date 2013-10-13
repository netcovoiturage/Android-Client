package ru.ododo.activities;


import nc_project_team.nc_prototypeinterface.R;
import android.app.Activity;
import android.os.Bundle;



public class SocialNetworkAuth extends Activity {

	//ключ для интента
	private final static String NAME_OF_SOCIAL_NETWORK="ru.ododo.android.client.SOCIALNETWORK";
	//с помощью какой соц.сети входим
	private static String ENTRY_BY_;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("Быстрый вход");
		setContentView(R.layout.social_network_auth);
		//название в виде префикса для соц.сети
		ENTRY_BY_=getIntent().getExtras().getString(NAME_OF_SOCIAL_NETWORK);
		}
		

}
