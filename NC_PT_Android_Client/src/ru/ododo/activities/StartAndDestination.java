package ru.ododo.activities;




import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import ru.ododo.logic.GPSTracker;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartAndDestination extends Activity implements OnClickListener {

	final String MY_TAG="myTag";
	Button btnOk;
	Button btnAbort;
	Button btnGetCord;
	
	EditText etStart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_and_destination);
		setTitle("Координаты");
		
		btnOk=(Button)findViewById(id.btnOk);
		btnAbort=(Button)findViewById(id.btnAbort);
		btnGetCord=(Button)findViewById(id.btnMyCord);
		
		etStart=(EditText)findViewById(id.etStart);
		btnOk.setOnClickListener(this);
		btnAbort.setOnClickListener(this);
	    btnGetCord.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.btnMyCord) {
			GPSTracker gps= new GPSTracker(this);
			if(gps.canGetLocation()){
                 
                 double latitude = gps.getLatitude();
                 double longitude = gps.getLongitude();
                 Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " 
		                 + latitude + "\nLong: "+longitude, Toast.LENGTH_LONG).show();
                 }
             else{
                 // can't get location
                 // GPS or Network is not enabled
                 // Ask user to enable GPS/network in settings
                 gps.showSettingsAlert();
             }
		} else {
		}
	}
}
