package com.current.part02;

public class BalancTest {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread t1 = new Thread(company);
		Bank bank = new Bank(account);
		Thread t2 = new Thread(bank);
		
		System.out.println("Initailized balance :" + account.getBalance());
		
		t1.start();
		t2.start();
		
		try {
			t2.join();
			t1.join();
			System.out.println("final balance:" + account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
