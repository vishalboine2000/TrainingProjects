package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.bean.Account;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException;
	Account searchAccount(int accountNumber) throws InvalidAccountNumberException;
    int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientBalanceException;
    int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
}