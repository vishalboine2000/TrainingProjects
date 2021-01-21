package com.capgemini.test;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.bean.Account;
import com.capgemini.repo.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
public class AccountTest {

	AccountService accountService;
	
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*
	 * create account
	 * 1.when the amount is less than 500 then system should throw exception
	 * 2.when the valid info is passed account should be created successfully
	 */
	
	@Test(expected=com.capgemini.exceptions.InsufficientOpeningAmountException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientOpeningAmountException
	{
		accountService.createAccount(101, 400);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenInvalidAccountSystemShouldThrowException() throws InvalidAccountNumberException
	{
		Account account=new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.depositAmount(102, 500);
	}	
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenValidAccountNumberShouldDepositSuccessfull() throws InvalidAccountNumberException
	{
		Account account=new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.depositAmount(101, 500);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenInsufficientBalanceShouldThrowException() throws InvalidAccountNumberException,InsufficientBalanceException
	{
		Account account =new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.withdrawAmount(101, 5500);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenSufficientBalanceShouldSuccessfull() throws InvalidAccountNumberException,InsufficientBalanceException
	{
		Account account =new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.withdrawAmount(101, 4500);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenInvalidAccountNumberWithrawShouldThrowException() throws InvalidAccountNumberException,InsufficientBalanceException
	{
		Account account =new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.withdrawAmount(102, 4500);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientOpeningAmountException
	{
		Account account =new Account(101,5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}
}
