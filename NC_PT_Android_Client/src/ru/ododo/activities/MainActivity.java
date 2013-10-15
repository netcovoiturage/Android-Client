package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button entryByVk;
	Button entryByFb;
	
	//ключ для интента
	private final static String NAME_OF_SOCIAL_NETWORK="ru.ododo.android.client.SOCIALNETWORK";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(R.string.name_reg_activity);
		
		entryByFb=(Button)findViewById(id.entryByFb);
		entryByVk=(Button)findViewById(id.entryByVk);
		
		entryByFb.setOnClickListener(this);
		entryByVk.setOnClickListener(this);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Intent intent=new Intent(this, SocialNetworkAuth.class);
		Intent intent=new Intent(this, StartAndDestination.class);
		switch (v.getId()) {
		case R.id.entryByFb:
			intent.putExtra(NAME_OF_SOCIAL_NETWORK, "_FB");
			startActivity(intent);
			break;

		case R.id.entryByVk:
			intent.putExtra(NAME_OF_SOCIAL_NETWORK, "_VK");
			startActivity(intent);
			break;
		}
	}

}
