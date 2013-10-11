package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartAndDestination extends Activity implements OnClickListener {

	Button btnOk;
	Button btnAbort;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_and_destination);
		setTitle("Координаты");
		
		btnOk=(Button)findViewById(id.btnOk);
		btnAbort=(Button)findViewById(id.btnAbort);
		
		btnOk.setOnClickListener(this);
		btnAbort.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btnAbort)
			this.finish();
	}

}
