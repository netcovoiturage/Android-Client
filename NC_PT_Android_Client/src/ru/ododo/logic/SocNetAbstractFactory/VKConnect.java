package ru.ododo.logic.SocNetAbstractFactory;

import java.util.concurrent.ExecutionException;

import android.util.Log;

import ru.ododo.logic.Settings;
import ru.ododo.logic.WebTask.GetUserName;

public class VKConnect extends AbstractProductSocNetConnect {
	
	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		
		String result=VK.getUserID();
		return result;
	}
	@Override
	public String getUserFullName() {
		// TODO Auto-generated method stub
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
		VK.setUserID("");
		Log.d(Settings.MY_TAG, "UserID has cleared");
		return result;
	}
	
	
}
