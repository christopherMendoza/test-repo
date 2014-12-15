/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.constant;

/**
 *
 * @author chris
 */
public enum TransactionConstant {
    DEPOSIT("D"),
    WITHDRAW("W"),
    FAST_CASH("F"),
    STATEMENT("S"),
    TRANSFER("T"),
    BALANCE("B"),
    TRANS_REPORT("R"),
    EXIT("X");
    
    private String value;
    
    private TransactionConstant(String value){
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
