package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.beans.Bank;
import com.revature.util.ConnectionUtil;

public class BankDao {

	public void safeSaveBank(Bank bank) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO accounts (account_type, balance) VALUES (?, ?) RETURNING account_id";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, bank.getAccountType());
			ps.setInt(2, bank.getBalance());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int accountId = rs.getInt("account_id");
				bank.setAccountId(accountId);
			}
			if (rs.next()) {
				int balance = rs.getInt("balance");
				bank.setBalance(balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void safeSaveDeposit(Bank bank) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE accounts set balance=? where account_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bank.getBalance());
			ps.setString(2, bank.getAccountType());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int balance = rs.getInt("balance");
				bank.setBalance(balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void safeSaveWithdrawal(Bank bank) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE accounts set balance=? where account_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bank.getBalance());
			ps.setString(2, bank.getAccountType());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int balance = rs.getInt("balance");
				bank.setBalance(balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}









