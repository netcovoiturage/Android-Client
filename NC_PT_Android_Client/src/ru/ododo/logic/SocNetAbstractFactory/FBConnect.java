package ru.ododo.logic.SocNetAbstractFactory;

import ru.ododo.logic.Settings;
import android.util.Log;






public class FBConnect extends AbstractProductSocNetConnect{

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		Log.d(Settings.MY_TAG, "UserID:"+FB.getUserId());
		return FB.getUserId();
	}

	@Override
	public String getUserFullName() {
		// TODO Auto-generated method stub
		return FB.getFullName();
	}

}
