package com.revature.views;

import com.revature.util.ScannerUtil;

public class MainMenu implements View {

	@Override
	public View printOptions() {
		System.out.println("==============================================================================================================================");
		System.out.println("WELCOME TO  R E V A T U R E  BANKING SERVICES [Main Menu]");
		System.out.println();
		
		System.out.println("[1] Information");
		System.out.println("[2] Accounts");
		System.out.println("[0] Quit");
		System.out.println();
	
		int selection = ScannerUtil.getNumericChoice(2);
		
		switch(selection) {
		case 1: return new InfoView();
		case 2: return new UserView();			
		default: return null;
		}
	}
}
