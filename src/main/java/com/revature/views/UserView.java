package com.revature.views;

import com.revature.services.UserService;
import com.revature.services.BankService;
import com.revature.util.ScannerUtil;

public class UserView implements View {

	UserService userService = new UserService();
	BankService bankService = new BankService();

	@Override
	public View printOptions() {
		System.out.println("==============================================================================================================================");
		System.out.println("ACCOUNT MANAGEMENT");
		System.out.println();

		System.out.println("[1] Login");
		System.out.println("[2] Create User Account");
		System.out.println("[3] Create Bank Account");
		System.out.println("[4] Switch Bank Account");
		System.out.println("[5] Transactions");
		System.out.println("[6] Back");
		System.out.println("[0] Quit");
		System.out.println();

		int selection = ScannerUtil.getNumericChoice(6);

		switch (selection) {	
		
		case 1:
			this.userService.userLogin();
			return this;
		
		case 2:
			this.userService.createUserAccount();
			return this;
		
		case 3:
			this.bankService.createBankAccount();
			return this;
			
		case 4:
			this.bankService.getBankAccount();
			
		case 5:
			return new TransactionView();
			
		case 6:
			return new MainMenu();
			
		default:
			return null;
		}
	}

}
