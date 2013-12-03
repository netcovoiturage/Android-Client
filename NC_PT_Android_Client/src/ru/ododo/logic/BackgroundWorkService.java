package ru.ododo.logic;





import ru.ododo.activities.MainMenu;
import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class BackgroundWorkService extends Service {

	NotificationManager nm;
	Notification toStatusBar;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d(Variables.MY_TAG, "Service create");
		nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(Variables.MY_TAG, "Service start command");
		
		Intent activityIntent=new Intent(this, MainMenu.class);
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);
		
		Notification toStatusBar=new NotificationCompat.Builder(this)
									.setContentText("HELLO")
									.setContentIntent(pIntent)
									.setContentText("ododo.ru")
									.setSmallIcon(R.drawable.ic_menu_compass)
									.setOngoing(true)
									.build();
		
		nm.notify(100500,toStatusBar);

		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(Variables.MY_TAG, "Service destroy");
		nm.cancel(100500);
	}

	

}
