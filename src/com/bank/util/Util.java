/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Method that handles the reading of file.
 * 
 * @author chris
 */
public class Util {
    
    /**
     * <p>This method checks if file folder is existing and readable.</p>
     *
     * @param fileFolderPath
     * @return boolean
     * @throws FileNotFoundException
     */
    public static boolean isFileFolderExist(String fileFolderPath) throws FileNotFoundException, NullPointerException {
        File file = new File(fileFolderPath);
        if (file.exists() == false || file.canRead() == false) {
            throw new FileNotFoundException("Cannot find folder specified : " + file);
        }
        return true;
    }
    
    /**
     * <p>This method Reads the file content.</p>
     *
     * 
     * 
     * @param filePath
     * @return List
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<String> readFile(String filePath) throws FileNotFoundException, IOException {
        List<String> lineStringArray = new ArrayList<>();
        if (null != filePath && filePath.isEmpty() == false) {

            if (isFileExist(filePath)) {
                try (FileReader fileReader = new FileReader(new File(filePath)); 
                        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                    String fileContent;

                    /*
                     * Put fileContent to lineStringArray... 
                     */
                    while ((fileContent = bufferedReader.readLine()) != null) {
                        if(!fileContent.trim().isEmpty()){
                            lineStringArray.add(fileContent);//removed trim method
                        }
                    }
                }
            }

        } else {
            throw new FileNotFoundException("Cannot find file specified : " + filePath);
        }

        return lineStringArray;
    }
    
    /**
     * <p>This method checks if file is existing and readable.</p>
     *
     * @param filePath
     * @return boolean
     * @throws FileNotFoundException
     */
    public static boolean isFileExist(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (file.exists() == false || file.canRead() == false) {
            throw new FileNotFoundException("Cannot find file specified : " + file);
        }
        return true;
    }

    public static void writeToFile(String filePath,String fileName,List<String> fileContent) throws IOException{
        
        File file = new File(filePath + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String line : fileContent) {
                fileWriter.write(line);
            }
            fileWriter.close();
        }
    }
    
     /**
     * Construct current date in time(yyyy-mm-dd HH:mm:ss:SSS z)
     *
     * @return - Return the current date time in String value.
     */
    public static String getCurrentDateTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentSystemDate = df.format(date);

        return currentSystemDate;

    }
}
