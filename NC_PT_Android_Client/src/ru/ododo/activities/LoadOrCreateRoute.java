package ru.ododo.activities;

import ru.ododo.logic.Variables;
import ru.ododo.logic.BackgroundWorkService;
import ru.ododo.logic.systemstate.SysSinglton;
import nc_project_team.nc_prototypeinterface.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoadOrCreateRoute extends Activity implements OnClickListener {


	String userId;
	String APIUrl;
	Button btnShutDownService;
	boolean stopService;
	
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
		
		btnShutDownService=(Button)findViewById(R.id.shutDownService);
		btnShutDownService.setOnClickListener(this);
		
		TextView tvHello=(TextView)findViewById(R.id.tvHello);
		tvHello.setText("Success!");
		Log.d(Variables.MY_TAG, "title:"+SysSinglton.getInstance().getUserFullName());
		if(SysSinglton.getInstance().getUserFullName()==null){
			Toast.makeText(this, "Network Error! Try again!", Toast.LENGTH_LONG).show();
			finish();
		}
		else{
			if(EnterSystem.getActiv()!=null)
				EnterSystem.getActiv().finish();
			if(EnterByVk.getAct()!=null)
				EnterByVk.getAct().finish();
			startService(new Intent(this, BackgroundWorkService.class));
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==btnShutDownService.getId()){
			stopService=true;
			finish();
		}
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(stopService)
			stopService(new Intent(this, BackgroundWorkService.class));
	}



}
