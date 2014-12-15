/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 *
 * @author chris
 */
public class User {
    private String customerId;
    private String customerNumber;
    private String passWord;
    private String userType;
    
    
    
    public void setCustomerId(String customerId){
        this.customerId=customerId;
    }
    public String getCustomerId(){
        return customerId;
    } 
    public void setCustomerNumber(String customerNumber){
        this.customerNumber=customerNumber;
    }
    public String getCustomerNumber(){
        return customerNumber;
    }
    public void setPassword(String passWord){
        this.passWord=passWord;
    }
    public String getPassword(){
        return passWord;
    }
    public void setUserType(String userType){
        this.userType=userType;
    }
    public String getUserType(){
        return userType;
    }
    
    public Object[] toObjectArray() {
        return new Object[]{getCustomerId(), getCustomerNumber(), getUserType()};
    }
}
