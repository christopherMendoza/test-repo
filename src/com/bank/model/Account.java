/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 * Class container for the customer account information.
 * 
 * @author chris
 */
public class Account {
    private String customerId;
    private String balance;

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
}
