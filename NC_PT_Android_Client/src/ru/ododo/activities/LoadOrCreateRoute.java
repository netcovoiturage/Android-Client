package ru.ododo.activities;

import ru.ododo.logic.Settings;
import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoadOrCreateRoute extends Activity implements OnClickListener {

	Button btnLoadRoute;
	Button btnNewRoute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_or_create_new_route);
		setTitle(R.string.name_routes);
		
		btnLoadRoute=(Button)findViewById(id.LoadRoute);
		btnNewRoute=(Button)findViewById(id.NewRoute);
		
		btnLoadRoute.setOnClickListener(this);
		btnNewRoute.setOnClickListener(this);
		
		SharedPreferences shr=getSharedPreferences(Settings.VK_USER_ID, MODE_PRIVATE);
		Toast.makeText(this, shr.getString(Settings.VK_USER_ID, "NOPE"), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch (v.getId()) {
		case R.id.LoadRoute:
			//go to list of routes
			intent=new Intent(this,ListOfRoutes.class);
			break;
		case R.id.NewRoute:
			intent=new Intent(this, NameOfNewRoute.class);
			break;
		}
		startActivity(intent);
		
	}

}
