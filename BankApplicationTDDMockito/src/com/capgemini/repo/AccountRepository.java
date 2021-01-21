package com.capgemini.repo;

import com.capgemini.bean.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountRepository {
	
	boolean save(Account account);
	
	Account searchAccount(int accountNumber);
	
    int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
    int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;


}
