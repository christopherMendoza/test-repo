/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.runner;

import com.bank.model.Account;
import com.bank.service.AccountService;
import com.bank.service.UserService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.service.impl.UserServiceImpl;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that will trigger running this application.
 *
 * @author chris
 */
public class MainRunner {
    
    private static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static AccountService transService = new AccountServiceImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("Enter your username: ");
        String customerId = scanner.next();
        
        System.out.print("Enter your password: ");
        String password = scanner.next();
        
        System.out.println("Validating username and password entered...");
        
        try {
            /*
            * Validate username and password by checking if the user exist in
            * user.flat file.
            */
            if(userService.isUserExist(customerId, password)){
                displayAvailableTransaction(customerId);
            }else{
                System.out.println("Invalid Credentials!");
            }
        } catch (Exception ex) {
            Logger.getLogger(MainRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
                     
    }
      private static void displayAvailableTransaction(String customerId){
          System.out.println("##################################################");
          System.out.println("Menu Screen:");
          System.out.println("D-----Deposit");
          System.out.println("W-----Withdraw");
          System.out.println("F-----Fast Cash");
          System.out.println("S-----Statement");
          System.out.println("T-----Transfer");
          System.out.println("B-----Balance");
          System.out.println("R-----Trans Report");
          System.out.println("X-----Exit");
          
          System.out.print("Please choose your desired transaction: ");
          
          String transaction = scanner.next();
          
          if(transaction!=null){
              
            //Check what transaction chose by the user
            switch(transaction.toUpperCase()){
                case "B":
                    /*
                     * Balance Inquiry
                     */
                    doBalance(customerId);
                    askOtherTran(customerId);
                    break;
                
                case "W":  
                    /*
                     * Withdraw Transaction
                     */
                    doWithdraw(customerId);
                    askOtherTran(customerId);
                    break;
                case "X": 
                    System.exit(0);
                    
            }  
          }
            
      } 
      
      /**
       * Method that will handle balance inquiry transaction.
       * 
       * @param customerId - customer id to be used for searching in the flat file.
       */
      private static void doBalance(String customerId){
        try {
            Account account = transService.getCustomerBalanceById(customerId);
            System.out.println("Customer Id: "+ account.getCustomerId());
            System.out.println("Your current balance is: "+ account.getBalance());
        } catch (Exception ex) {
            Logger.getLogger(MainRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
      
      /**
     * This method handles asking user if he wants to perform other transaction.
     */
    private static void askOtherTran(String customerId) {
        System.out.print("Would you like to perform another transaction? [Y/N]: ");
        String otherTran = scanner.next();
        if(otherTran.equalsIgnoreCase("Y")){
            displayAvailableTransaction(customerId);
        }else{
            System.exit(0);
        }
    }
    
    /**
       * Method that will handle balance inquiry transaction.
       * 
       * @param customerId - customer id to be used for searching in the flat file.
       */
      private static void doWithdraw(String customerId){
        try {
            
            System.out.print("Enter amount >> ");
            int amount = scanner.nextInt();
            
            transService.withDraw(customerId,amount);
            
            System.out.println("You have Successfully withdrawn!");
        } catch (Exception ex) {
            Logger.getLogger(MainRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
}

