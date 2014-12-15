/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 *
 * @author chris
 */
public class Customer {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerAccount;
    
    public void setCustomerId(String customerId){
        this.customerId=customerId;
    }
    public String getCustomerId(){
        return customerId;
    } 
    public void setCustomerName (String customerName){
        this.customerName=customerName;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerAddress(String customerAddress){
        this.customerAddress=customerAddress;
    }
    public String getCustomerAddress(){
        return customerAddress;
    }
    public void setCustomerAccount(String customerAccount){
        this.customerAccount=customerAccount;
    }
    public String getCustomerAccount(){
        return customerAccount;
    }
}
