package ru.ododo.logic;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class androidService extends Service {


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d(Variables.MY_TAG, "Service create");

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(Variables.MY_TAG, "Service start command");
		
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(Variables.MY_TAG, "Service destroy");
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
