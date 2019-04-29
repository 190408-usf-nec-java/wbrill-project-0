package com.revature.views;

import com.revature.services.UserService;
import com.revature.services.BankService;
import com.revature.util.ScannerUtil;

public class TransactionView implements View {

	UserService userService = new UserService();
	BankService bankService = new BankService();

	@Override
	public View printOptions() {
		System.out.println("==============================================================================================================================");
		System.out.println("TRANSACTIONS");
		System.out.println();

		System.out.println("[1] < DEPOSIT  >");
		System.out.println("[2] < WITHDRAW >");
		System.out.println("[3] < TRANSFER >");
		System.out.println("[4] Back");
		System.out.println("[5] Main Menu");
		System.out.println("[0] Quit");
		System.out.println();

		int selection = ScannerUtil.getNumericChoice(5);

		switch (selection) {	
		case 1:
			this.bankService.makeDeposit();
			return this;
		
		case 2:
			this.bankService.makeWithdrawal();
			return this;
			
		case 3:
			this.bankService.makeTransfer();
			return this;
			
		case 4:
			return new UserView();
			
			
		case 5:
			return new MainMenu();
			
		default:
			return null;
		}
	}

}
