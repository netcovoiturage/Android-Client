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
		Intent intent=new Intent(this, LoadOrCreateRoute.class);
		switch (v.getId()) {
		case R.id.entryByFb:
			startActivity(intent);
			break;

		case R.id.entryByVk:
			startActivity(intent);
			break;
		}
	}

}
