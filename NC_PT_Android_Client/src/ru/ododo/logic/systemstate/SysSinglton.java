package ru.ododo.logic.systemstate;

import ru.ododo.logic.SocNetAbstractFactory.AbstractFactory;
public class SysSinglton {
	
	private static SysSinglton singlton;
	
	private String userId=null;
	private String userFullName=null;
	
	private double latitude = 53.21701;
	private double longitude = 50.22159;
	
	private boolean isServiceRun;
	
    public boolean isServiceRun() {
		return isServiceRun;
	}
	public void setServiceRun(boolean isServiceRun) {
		this.isServiceRun = isServiceRun;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	private SysSinglton(){
		
	}
	static void initSinglton(){
		if(singlton==null){
			singlton=new SysSinglton();
		}
	}
	public static SysSinglton getInstance(){
		return singlton;
	}
	
	public void createUser(AbstractFactory factory){
		
		userId=factory.create().getUserId();
		userFullName=factory.create().getUserFullName();
	}
	public String getUserId() {
		return userId;
	}
	public String getUserFullName() {
		return userFullName;
	}
}
