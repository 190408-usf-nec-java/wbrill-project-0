package com.revature.views;

public class InfoView implements View {

	@Override
	public View printOptions() {
		System.out.println("==============================================================================================================================");
		System.out.println("INFORMATION");
		System.out.println();
		
		System.out.println("Thank you for your interest in RBS™! (2019 Revature Banking Services).");
		System.out.println("If you have just signed up, welcome! Else, please review the signup information below.");
		System.out.println();
		System.out.println("You can register for multiple bank accounts, none of which have a monthly fee.");
		System.out.println("The email address you register your account with will be your username.");
		System.out.println("If you would like to setup an account, please select 'Accounts' from the [Main Menu] below.");
		
		return new MainMenu();
	}

}