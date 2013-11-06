package ru.ododo.logic.SocNetAbstractFactory;

import java.util.concurrent.ExecutionException;

import android.util.Log;

import ru.ododo.logic.Settings;
import ru.ododo.logic.WebTask.GetUserName;
import ru.ododo.logic.WebTask.GetUsetId;

public class VKConnect extends AbstractProductSocNetConnect {
	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		
		String result="";
		GetUsetId task=new GetUsetId();
		task.execute();
		try {
			result=task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(Settings.MY_TAG, "user id="+result);
		return result;
	}
	@Override
	public String getUserFullName() {
		// TODO Auto-generated method stub
		Log.d(Settings.MY_TAG, "getFullname from server");
		String result="";
		GetUserName task=new GetUserName();
		task.execute();
		try {
			result=task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(Settings.MY_TAG, "user first and last name:"+result);
		return result;
	}
	
	
}
