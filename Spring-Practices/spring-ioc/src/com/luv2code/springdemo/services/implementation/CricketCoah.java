package com.luv2code.springdemo.services.implementation;
import com.luv2code.springdemo.services.interfaces.*;;

public class CricketCoah implements Coach {

	private FortuneService fortuneSerivce;
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach: We are in the Cricket object setting Email");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach: We are in the Cricket object setting Team ");
		this.team = team;
	}

	private String team;
	public CricketCoah ()
	{
		System.out.println("Cricket Coach: We are in the Cricket object Creating Object");
	}

	public FortuneService getFortuneSerivce() {
		
		return fortuneSerivce;
	}

	public void setFortuneSerivce(FortuneService fortuneSerivce) {
		
		System.out.println("Cricket Coach: We are in the Cricket object setting Fortune Services");
		this.fortuneSerivce = fortuneSerivce;
	}

	@Override
	public String getDialyWorkout() {
		// TODO Auto-generated method stub
		return "run with the cricket ball 30 minute";
	}

	@Override
	public String getDialyFortune() {
		// TODO Auto-generated method stub
		return fortuneSerivce.getFortune();
	}

}
