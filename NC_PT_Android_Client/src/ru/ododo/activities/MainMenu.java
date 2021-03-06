package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import ru.ododo.logic.BackgroundWorkService;
import ru.ododo.logic.GPSTracker;
import ru.ododo.logic.Variables;
import ru.ododo.logic.systemstate.SysSinglton;
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

public class MainMenu extends Activity implements OnClickListener {


	String userId;
	String APIUrl;
	Button btnShutDownService;
	Button btnShowMyLocation;
	Button btnMap;
	boolean stopService;
	TextView coordinates;
	// GPSTracker class
    GPSTracker gps;
	
	private static ProgressDialog pb;
	//private static LoadOrCreateRoute mySelfRef;
	
	public static ProgressDialog getPb() {
		return pb;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		setTitle("Hello, "+SysSinglton.getInstance().getUserFullName());
		
		if(SysSinglton.getInstance().isServiceRun()){
			stopService(new Intent(this, BackgroundWorkService.class));
			SysSinglton.getInstance().setServiceRun(false);
		}
		
		btnShutDownService=(Button)findViewById(R.id.shutDownService);
		btnShutDownService.setOnClickListener(this);
		
		btnShowMyLocation=(Button)findViewById(R.id.myLocation);
		btnShowMyLocation.setOnClickListener(this);
		
		findViewById(R.id.btnMap).setOnClickListener(this);
		
		
		coordinates=(TextView)findViewById(R.id.tvHello);
		 coordinates.setText("Your Location is - \nLat: "
         		+ SysSinglton.getInstance().getLatitude() + "\nLong: " + SysSinglton.getInstance().getLongitude());
		Log.d(Variables.MY_TAG, "title:"+SysSinglton.getInstance().getUserFullName());
		if(SysSinglton.getInstance().getUserFullName()==null){
			Toast.makeText(this, "Network Error! Try again!", Toast.LENGTH_LONG).show();
			finish();
		}
		else{
			if(EnterToSystem.getActiv()!=null)
				EnterToSystem.getActiv().finish();
			if(EnterByVk.getAct()!=null)
				EnterByVk.getAct().finish();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shutDownService:
			stopService=true;
			finish();
			break;
		case R.id.myLocation:
			// create class object
            gps = new GPSTracker(this);

            // check if GPS enabled    
            if(gps.canGetLocation()){
                 
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();
                
                SysSinglton.getInstance().setLatitude(latitude);
                SysSinglton.getInstance().setLongitude(longitude);
                
                
                coordinates.setText("Your Location is - \nLat: "
                		+ latitude + "\nLong: " + longitude);
            }else{
                // can't get location
                // GPS or Network is not enabled
                // Ask user to enable GPS/network in settings
                gps.showSettingsAlert();
            }
			break;
			case R.id.btnMap:
				startActivity(new Intent(this, Map.class));
			break;
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(stopService){
			stopService(new Intent(this, BackgroundWorkService.class));
			SysSinglton.getInstance().setServiceRun(false);
		}
		else{
			startService(new Intent(this, BackgroundWorkService.class));
			SysSinglton.getInstance().setServiceRun(true);
		}
	}

}
