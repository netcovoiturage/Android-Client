package ru.ododo.activities;

import ru.ododo.logic.Settings;
import ru.ododo.logic.systemstate.SysSinglton;
import nc_project_team.nc_prototypeinterface.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class LoadOrCreateRoute extends Activity {


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
		TextView tvHello=(TextView)findViewById(R.id.tvHello);
		tvHello.setText("Success!");
		Log.d(Settings.MY_TAG, "title:"+SysSinglton.getInstance().getUserFullName());
		if(SysSinglton.getInstance().getUserFullName()==null){
			Toast.makeText(this, "Network Error! Try again!", Toast.LENGTH_LONG).show();
			finish();
		}
		else{
			if(MainActivity.getActiv()!=null)
				MainActivity.getActiv().finish();
			if(EnterByVk.getAct()!=null)
				EnterByVk.getAct().finish();
		}
		//mySelfRef=LoadOrCreateRoute.this;
		

	}



}
