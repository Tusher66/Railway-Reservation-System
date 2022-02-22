package com.train.booking;

public class BankAccount {

	  private int actNumber;
	  private int actBalance;
	  
		public int getActNumber() {
			return actNumber;
		}
		public int getActBalance() {
			return actBalance;
		}
	  
	public void setActNumber(int actNumber) {
		this.actNumber = actNumber;
	}
	public void setActBalance(int actBalance) {
		this.actBalance = actBalance;
	}
	
	public void deposit(int amount) {
		actBalance +=amount;
	}
	
	public void withdraw(int amount) {
		actBalance -=amount;
	}
	public void showBalance() {
		System.out.println("Act Balance= " +actBalance);
	}

	  
	  
}
