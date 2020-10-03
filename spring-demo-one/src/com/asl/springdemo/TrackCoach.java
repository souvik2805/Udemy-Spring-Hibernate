package com.asl.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	

	public TrackCoach() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getDailyWorkout() {
		return "Run Hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It : "+ fortuneService.getFortune();
	}

}
