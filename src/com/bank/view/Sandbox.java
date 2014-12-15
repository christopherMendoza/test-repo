/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author christopher_mendoza
 */
public class Sandbox {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
         Calendar s = Calendar.getInstance();
        String dateText = format.format(s.getTime());
        
        System.out.println("Date: " + dateText);
    }
}
