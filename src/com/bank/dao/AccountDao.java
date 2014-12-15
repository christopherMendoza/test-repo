/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.Account;

/**
 * Interface class that contains the list of transaction available for the customer.
 * 
 * @author chris
 */
public interface AccountDao {
    public Account getCustomerBalanceById(String customerId) throws Exception;
    public void withDraw(String customerId,int amount) throws Exception;
}
