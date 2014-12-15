/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao.impl;

import com.bank.constant.DelimeterConstant;
import com.bank.constant.TransactionTypeConstant;
import com.bank.dao.AccountDao;
import com.bank.model.Account;
import com.bank.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for TransactionDao.
 *
 * @see AccountDao
 *
 * @author chris
 */
public class AccountDaoImpl implements AccountDao {

    @Override
    public Account getCustomerBalanceById(String customerId) throws FileNotFoundException, IOException {
        Account retVal = new Account();
        if (customerId != null) {
            List<String> accountContents = Util.readFile("E:\\bankfile\\accounts.flat");
            int ctr = 0;
            for (String account : accountContents) {
                ctr++;
                if (ctr == 1) {
                    continue;
                }

                String[] accountArr;
                accountArr = account.split(DelimeterConstant.PIPE.getValue());

                //Get specific value
                String custId = accountArr[0];
                String bal = accountArr[1];

                if (custId.equalsIgnoreCase(customerId)) {
                    retVal.setCustomerId(custId);
                    retVal.setBalance(bal);

                    break;
                }
            }
        }

        return retVal;
    }

    @Override
    public void withDraw(String customerId, int amount) throws Exception {
        //Reading file content.
        List<String> accounts = Util.readFile("E:\\bankfile\\accounts.flat");
        List<String> statements = Util.readFile("E:\\bankfile\\statement.flat");
        List<String> atmsts = Util.readFile("E:\\bankfile\\atmstatus.flat");

        //Update account
        if (accounts.isEmpty() == false) {

            List<String> updatedAccount = new ArrayList<>();
            int ctr = 0;
            for (String acc : accounts) {
                ctr++;

                if (ctr == 1) {
                    updatedAccount.add(acc);
                    continue;
                }

                String[] accArr = acc.split(DelimeterConstant.PIPE.getValue());

                if (accArr[0].equalsIgnoreCase(customerId)) {

                    StringBuilder updatedaccountamount = new StringBuilder();

                    //Deduct the amount withdrawn
                    int updatedAmtVal = Integer.parseInt(accArr[1]) - amount;

                    //Construct the account information
                    updatedaccountamount.append(customerId);
                    updatedaccountamount.append("|");
                    updatedaccountamount.append(updatedAmtVal);

                    //Add to the list
                    updatedAccount.add(updatedaccountamount.toString());
                } else {
                    updatedAccount.add(acc);
                }
            }

            //Write to account.file to update the information
            Util.writeToFile("E:\\bankfile\\", "accounts.flat", updatedAccount);

            //Cosntruct the information to be added in statement log list
            StringBuilder stmtConstructor = new StringBuilder();
            stmtConstructor.append(customerId);
            stmtConstructor.append("|");
            stmtConstructor.append(Util.getCurrentDateTime());
            stmtConstructor.append("|");
            stmtConstructor.append(TransactionTypeConstant.DEPOSIT.getValue());
            stmtConstructor.append("|");
            stmtConstructor.append(amount);

            statements.add(stmtConstructor.toString());
            //Add to statement log(statment.flat file)
            Util.writeToFile("E:\\bankfile\\", "statement.flat", statements);

            //Update ATMStatus flat file.
            if (atmsts.isEmpty() == false) {

                List<String> updatedAtmSts = new ArrayList<>();

                int counter = 0;
                for (String atmstat : atmsts) {
                    
                    counter++;

                    if (counter == 1) {
                        updatedAtmSts.add(atmstat);
                        continue;
                    }

                    String[] updateAtmStsVal = atmstat.split(DelimeterConstant.PIPE.getValue());
                    
                    
                    int atmAmountBal = Integer.parseInt(updateAtmStsVal[0]) - amount;

                    StringBuilder atmStsBuilder = new StringBuilder();
                    atmStsBuilder.append(atmAmountBal);
                    atmStsBuilder.append(DelimeterConstant.PIPE.getValue());
                    atmStsBuilder.append(updateAtmStsVal[1]);

                    updatedAtmSts.add(atmStsBuilder.toString());

                }

                Util.writeToFile("E:\\bankfile\\", "atmstatus.lat", updatedAtmSts);
            }
        }
    }
}
