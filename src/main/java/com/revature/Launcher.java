package com.revature;

import com.revature.views.MainMenu;
import com.revature.views.View;

public class Launcher {
	public static void main(String[] args) {
		View view = new MainMenu();
		
		
		while(view != null) {
			view = view.printOptions();
		}
		
		System.out.println();
		System.out.println("Thank you for choosing RBS™. 2019 R E V A T U R E Banking Services Corporation. All rights reserved.");
	}
}