/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.impl.AccountDaoImpl;
import com.bank.model.Account;
import com.bank.service.AccountService;

/**
 * Implementation class for TransactionService interface.
 * 
 * @see TranAccountService
 * @author chris
 */
public class AccountServiceImpl implements AccountService{
    
    AccountDao accountDao = new AccountDaoImpl();
    
    @Override
    public Account getCustomerBalanceById(String customerId) throws Exception {
        return accountDao.getCustomerBalanceById(customerId);
    }

    @Override
    public void withDraw(String customerId, int amount) throws Exception {
        accountDao.withDraw(customerId, amount);
    }
    
}
