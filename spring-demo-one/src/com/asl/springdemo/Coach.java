package com.asl.springdemo;

public interface Coach {
	
	public   String getDailyWorkout();
	
	public default String Name() {
		return "You can Do It";
	}

}
