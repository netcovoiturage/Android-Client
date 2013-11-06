package ru.ododo.activities;

import ru.ododo.logic.Settings;
import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {



	Button entryByVk;
	Button entryByFb;
	Intent intent;

		
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
		intent=new Intent(this, SocialNetworkAuth.class);
		int id = v.getId();
		if (id == R.id.entryByFb) {
			intent.putExtra(Settings.NAME_OF_SOCIAL_NETWORK, "_FB");
			startActivityForResult(intent,1);
		} else if (id == R.id.entryByVk) {
			intent.putExtra(Settings.NAME_OF_SOCIAL_NETWORK, "_VK");
			startActivityForResult(intent,1);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data!=null){
			int result=data.getIntExtra("get_id", Settings.STATUS_FAILED);
			if(result==Settings.STATUS_FAILED){
				Toast.makeText(this, "Error: check network", Toast.LENGTH_SHORT).show();
			}
			else{
				Intent intent=new Intent(this, LoadOrCreateRoute.class);
				startActivity(intent);
				
			}
		}
		else{
			Log.d(Settings.MY_TAG, "data is null");
		}
	}
}
