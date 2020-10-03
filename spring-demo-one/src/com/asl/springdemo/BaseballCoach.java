package com.asl.springdemo;

public class BaseballCoach implements Coach{
    
	//Define a Private Field for the dependency
	private FortuneService fortuneService;
	
	//Define a constructor for Denpendency for injection
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice:::";
	}

	@Override	
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
