package com.asl.springdemo;

public class MyApp {

	public static void main(String[] args) {

		Coach theCoach = new TrackCoach();

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.Name());

	}

}
