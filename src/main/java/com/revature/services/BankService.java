package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Bank;
import com.revature.daos.BankDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;

public class BankService {
	
	public BankDao bankDao=new BankDao();
	
	public void setDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	
	/**
	 * Handles creation workflow for Bank bean
	 */
	public void createBankAccount() {
		
		System.out.println("Please enter the type of account you would like to create: ");
		String accountType = ScannerUtil.getLine();
		
		Bank bank = new Bank(0, accountType, 0);

		bankDao.safeSaveBank(bank);
		System.out.println(bank);
	}
	
	int balance = 0;
	int deposit = 0;
	int withdrawal = 0;
	int number = 0;
	
	public void makeDeposit() {
		
		System.out.println("Please enter the amount you would like to deposit.");
		String number = ScannerUtil.getLine();
		int deposit = Integer.parseInt(number);
		balance = balance + deposit;
		System.out.println();
		System.out.println("Your current balance is $" + balance + ".");

	}
	
	public void makeWithdrawal() {
		
		if (balance < number) {
			System.out.println();
			System.out.println("INSUFFICIENT FUNDS.");
			System.out.println("Your account has been overdrafted.");
			return;
		}
		
		System.out.println("Please enter the amount you would like to withdraw.");
		String number = ScannerUtil.getLine();
		int deposit = Integer.parseInt(number);
		balance = balance - deposit;
		System.out.println();
		System.out.println("Your current balance is $" + balance + ".");

	}
	
	public void makeTransfer() {
		
		System.out.println();
		System.out.println("This functionality is not available at this time.");
		System.out.println("We apologize for any inconvenience.");

	}
	
	public void getBankAccount() {
		Set<String> bankAccount = new HashSet<>();
		boolean bankAccountExists = false;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select account_type from accounts";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bankAccount.add(rs.getString(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		while(!bankAccountExists) {
			
			System.out.println("Which bank account would you like to manage?");
			String bankAccounts = ScannerUtil.getLine();
			
			if (bankAccount.contains(bankAccounts)) {
				System.out.println("Welcome to your " + bankAccounts + ". ");
				bankAccountExists = true;
			
			}
			
			else {
				System.out.println("You need to create the account type you are trying to access, or enter a valid type.");
			}
		}
	}
}