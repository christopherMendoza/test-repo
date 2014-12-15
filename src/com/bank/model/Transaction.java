/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 *
 * @author chris
 */
public class Transaction {
    private String customerId;
    private String transactionType;
    private String transactionAmt;
    private String transactionAmtTo;
    private String transactionAmtFrom;
    private String transactionDate;

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
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the transactionAmt
     */
    public String getTransactionAmt() {
        return transactionAmt;
    }

    /**
     * @param transactionAmt the transactionAmt to set
     */
    public void setTransactionAmt(String transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    /**
     * @return the transactionAmtTo
     */
    public String getTransactionAmtTo() {
        return transactionAmtTo;
    }

    /**
     * @param transactionAmtTo the transactionAmtTo to set
     */
    public void setTransactionAmtTo(String transactionAmtTo) {
        this.transactionAmtTo = transactionAmtTo;
    }

    /**
     * @return the transactionAmtFrom
     */
    public String getTransactionAmtFrom() {
        return transactionAmtFrom;
    }

    /**
     * @param transactionAmtFrom the transactionAmtFrom to set
     */
    public void setTransactionAmtFrom(String transactionAmtFrom) {
        this.transactionAmtFrom = transactionAmtFrom;
    }

    /**
     * @return the transactionDate
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
