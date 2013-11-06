package ru.ododo.activities;

import nc_project_team.nc_prototypeinterface.R;
import nc_project_team.nc_prototypeinterface.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ListOfRoutes extends Activity implements OnClickListener {
	
	Button btnOk;
	Button btnAbort;
	ListView lvRoutes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_of_routes);
		setTitle("saved routes");
		
		btnOk=(Button)findViewById(id.btnChoose);
		btnAbort=(Button)findViewById(id.btnAbortList);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu_of_routes_list, menu);		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.menuEdit) {
			Intent intent=new Intent(this, StartAndDestination.class);
			startActivity(intent);
		} else if (itemId == R.id.menuDelete) {
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.btnChoose) {
		} else if (id == R.id.btnAbortList) {
			this.finish();
		}
	}

}
