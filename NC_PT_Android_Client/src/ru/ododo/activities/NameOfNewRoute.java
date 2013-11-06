package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NameOfNewRoute extends Activity implements OnClickListener{

	Button btnOk;
	Button btnAbort;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_of_new_route);
		setTitle(R.string.name_of_new_route);
		
		btnOk=(Button)findViewById(id.okBtn);
		btnAbort=(Button)findViewById(id.abortBtn);
		
		btnAbort.setOnClickListener(this);
		btnOk.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.abortBtn) {
			this.finish();
		} else if (id == R.id.okBtn) {
			//go to another activity
			Intent intent=new Intent(this,StartAndDestination.class);
			startActivity(intent);
		}
	}
	
}
