package com.capgemini.service;
import java.util.LinkedList;
import com.capgemini.bin.Account;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;

public  class  ICICIBank implements Bank {
	LinkedList<Account> accounts=new LinkedList<>();
	
	
	public  String createAccount(int accountNumber,int amount)throws InsufficientOpeningAmountException
	{
		
		if(amount>=500) 
		{
			Account account = new Account(accountNumber,amount);
			accounts.add(account);
			return "account created successfully";
		}
		throw new InsufficientOpeningAmountException();
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
	
	public int[] fundTransfer(int senderAccountNumber,int recieverAcoountNumber,int transferAmount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		
		Account accountSender =searchAccount(senderAccountNumber);
		Account accountReciever=searchAccount(recieverAcoountNumber);
		
		if(accountSender.getAmount()>=transferAmount)
		{
			int[] a= {accountSender.getAmount()-transferAmount,accountReciever.getAmount()+transferAmount};
			accountSender.setAmount(accountSender.getAmount()-transferAmount);
			accountReciever.setAmount(accountReciever.getAmount()+transferAmount);
			return a;
			
		}
		throw new InsufficientBalanceException();
	}
	
	
	public int depositeAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
		
	}
}
