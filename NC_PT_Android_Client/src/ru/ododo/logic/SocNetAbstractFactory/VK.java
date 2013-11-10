package ru.ododo.logic.SocNetAbstractFactory;

public class VK extends AbstractFactory{
	static String userID;
	public static String getUserID() {
		return userID;
	}
	public static void setUserID(String userID) {
		VK.userID = userID;
	}
	@Override
	public AbstractProductSocNetConnect create() {
		// TODO Auto-generated method stub
		return new VKConnect();
	}

}
