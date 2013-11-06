package ru.ododo.logic.SocNetAbstractFactory;

import ru.ododo.logic.WebTask.GetFBUser;

import com.facebook.model.GraphUser;


public class FBConnect extends AbstractProductSocNetConnect{

	static GraphUser user=null;
	GetFBUser FBWebTask;
	
	public static GraphUser getUser() {
		return user;
	}

	public static void setUser(GraphUser user) {
		FBConnect.user = user;
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		if(user==null){
			FBWebTask=new GetFBUser();
			FBWebTask.execute();
		}
		return user.getId();
	}

	@Override
	public String getUserFullName() {
		// TODO Auto-generated method stub
		String fullName="";
		if(user==null){
			FBWebTask=new GetFBUser();
			FBWebTask.execute();
		}
		fullName=user.getFirstName()+" "+user.getLastName();
		return fullName;
	}

}
