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
import android.widget.ArrayAdapter;
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
		
		lvRoutes=(ListView)findViewById(id.lvOfRoutes);
		lvRoutes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
			R.array.routes, android.R.layout.simple_list_item_single_choice);
		lvRoutes.setAdapter(adapter);
		
		btnOk.setOnClickListener(this);
		btnAbort.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu_of_routes_list, menu);		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuEdit:
			Intent intent=new Intent(this, StartAndDestination.class);
			startActivity(intent);
			break;

		case R.id.menuDelete:
			//to do something
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnChoose:
			//to do something
			break;
		case R.id.btnAbortList:
			this.finish();
			break;
		}
	}

}
