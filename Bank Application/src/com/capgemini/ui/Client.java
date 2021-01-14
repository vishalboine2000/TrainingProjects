package com.capgemini.ui;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;

public class Client {

	public static void main(String[] args) {
		Bank bank = new ICICIBank();
		try
		{
			System.out.println(bank.createAccount(101, 3000));
			System.out.println(bank.createAccount(102, 3000));
			System.out.println("---Withdrawing---");
			System.out.println("Balance after withdrawal = "+bank.withdrawAmount(101, 2000));
			int a[]=bank.fundTransfer(101,102,500);
			System.out.println("---Fund Transferring---");
			System.out.println("Sender balance after fund transfer = "+a[0]);
			System.out.println("Reciever balance after fund transfer = "+a[1]);
			System.out.println("---Depositing---");
			System.out.println("Account balance after deposite = "+bank.depositeAmount(101, 500));
			System.out.println("Checking for minimum balance while creating account...");
			System.out.println(bank.createAccount(103, 200));
			
		}
		catch(InsufficientOpeningAmountException iae) {
			System.out.println("Minimum Balance must be 500");
		}
		catch(InvalidAccountNumberException i)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){
			System.out.println("insufficient balance");
		}
	}

}
