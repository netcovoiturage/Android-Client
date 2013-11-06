package ru.ododo.logic.SystemState;

import android.util.Log;
import ru.ododo.logic.Settings;
import ru.ododo.logic.SocNetAbstractFactory.AbstractFactory;
public class SysSinglton {
	
	private static SysSinglton singlton;
	
	private String userId=null;
	private String userFullName=null;
	
	private SysSinglton(){
		
	}
	static void initSinglton(){
		if(singlton==null){
			Log.d(Settings.MY_TAG,"initSinglton");
			singlton=new SysSinglton();
		}
	}
	
	public static SysSinglton getInstance(){
		Log.d(Settings.MY_TAG,"getInstance");
		return singlton;
	}
	
	public void createUser(AbstractFactory factory){
		if(userFullName==null&&userId==null){
			userId=factory.create().getUserId();
			userFullName=factory.create().getUserFullName();
		}
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserFullName() {
		return userFullName;
	}
}
