package ru.ododo.logic.SocNetAbstractFactory;

public class FB extends AbstractFactory{
	static String fullName;
	static String userId;
	public static String getFullName() {
		return fullName;
	}
	public static void setFullName(String fullName) {
		FB.fullName = fullName;
	}
	public static String getUserId() {
		return userId;
	}
	public static void setUserId(String userId) {
		FB.userId = userId;
	}
	@Override
	public AbstractProductSocNetConnect create() {
		// TODO Auto-generated method stub		
		return new FBConnect();
	}

}
