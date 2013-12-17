package ru.ododo.activities;



import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import ru.ododo.logic.systemstate.SysSinglton;

import android.app.Activity;
import android.os.Bundle;



public class Map extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.map);
		setTitle("Map");
		MapView mapView = new MapView(this, 256); //constructor
        mapView.setClickable(true);

        mapView.setBuiltInZoomControls(true);

        setContentView(mapView); //displaying the MapView

        mapView.setUseDataConnection(true);
        
        mapView.getController().setZoom(15); //set initial zoom-level, depends on your need

        mapView.getController().setCenter(new GeoPoint(SysSinglton.getInstance().getLatitude(), 
        		SysSinglton.getInstance().getLongitude()));
       
        
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
