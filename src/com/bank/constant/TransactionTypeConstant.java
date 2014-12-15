/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.constant;

/**
 *
 * @author chris
 */
public enum TransactionTypeConstant {
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW"),
    FAST_CASH("FAST CASH"),
    STMT("STATEMENT"),
    TRANSFER("TRANSFER"),
    BALANCE("BALANCE"),
    TRANS_REPORT("TRANS REPORT");
    
    private String value;
    
    private TransactionTypeConstant(String value){
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}