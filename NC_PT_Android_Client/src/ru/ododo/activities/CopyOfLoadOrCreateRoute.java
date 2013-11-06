package ru.ododo.activities;

import ru.ododo.logic.SystemState.SysSinglton;
import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CopyOfLoadOrCreateRoute extends Activity implements OnClickListener {

	Button btnLoadRoute;
	Button btnNewRoute;
	String userId;
	String APIUrl;
	
	private static ProgressDialog pb;
	//private static LoadOrCreateRoute mySelfRef;
	
	public static ProgressDialog getPb() {
		return pb;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_or_create_new_route);
		setTitle("Hello, "+SysSinglton.getInstance().getUserFullName());
		
		//mySelfRef=LoadOrCreateRoute.this;
		
		btnLoadRoute=(Button)findViewById(id.LoadRoute);
		btnNewRoute=(Button)findViewById(id.NewRoute);
		
		btnLoadRoute.setOnClickListener(this);
		btnNewRoute.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		int id = v.getId();
		if (id == R.id.LoadRoute) {
			//go to list of routes
			intent=new Intent(this,ListOfRoutes.class);
		} else if (id == R.id.NewRoute) {
			intent=new Intent(this, NameOfNewRoute.class);
		}
		startActivity(intent);
		
	}

}
