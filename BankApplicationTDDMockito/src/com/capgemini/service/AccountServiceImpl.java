package com.capgemini.service;

import com.capgemini.exceptions.InsufficientOpeningAmountException;

import java.util.LinkedList;

import com.capgemini.bean.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repo.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	private LinkedList<Account> accounts=new LinkedList<>();
	AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException
	{
		if(amount<500)
		{
			throw new InsufficientOpeningAmountException();
		}
		Account account = new Account(accountNumber,amount);
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		 
		if(accountRepository.save(account))
		{
			return account;
		}
	     
		return null;
		
	}
	public Account searchAccount(int accountNumber)throws InvalidAccountNumberException
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
	
	
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
	
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
}
