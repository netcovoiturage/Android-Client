package ru.ododo.logic.SystemState;


import android.app.Application;

public class SysState extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SysSinglton.initSinglton();
		
	}
	
}
