/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao.impl;

import com.bank.constant.DelimeterConstant;
import com.bank.dao.UserDao;
import com.bank.model.User;
import com.bank.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * Implementation class for UserDaointerface.
 * 
 * @see UserDao
 * 
 * @author chris
 */
public class UserDaoImpl implements UserDao{

    @Override
    public void addUser(User user) throws IOException {
        
        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append(user.getCustomerId());
        userBuilder.append(DelimeterConstant.PIPE.getValue());
        userBuilder.append(user.getCustomerNumber());
        userBuilder.append(DelimeterConstant.PIPE.getValue());
        userBuilder.append(user.getPassword());
        userBuilder.append(DelimeterConstant.PIPE.getValue());
        userBuilder.append(user.getUserType());
        
        List<String> userFileContent = Util.readFile("F:/bankfile/user.flat");
        userFileContent.add(String.valueOf(userBuilder));
//        Util.writeToFile("F:/bankfile/", "user.flat", userFileContent);
        File file = new File("F:/bankfile/user.flat");
        FileUtils.writeLines(file, userFileContent);
        
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUserById(String userId) throws FileNotFoundException, IOException {
        User retVal = new User();
        
        if(userId.length()==0){
            
           System.out.println("Parameter User Id is NULL returning empty user object...");
            return retVal;
        }
        
        List<String> userFileContent = Util.readFile("F:/bankfile/user.flat");
        
        if(userFileContent.isEmpty()==false){
            for(String fileContent:userFileContent){
                
                if(fileContent==null){
                    continue;
                }
                
                String[] userArr = fileContent.split(DelimeterConstant.PIPE.getValue());
                
                if(userId.equalsIgnoreCase(userArr[0])) {
                    
                    retVal.setCustomerId(userArr[0]);
                    retVal.setCustomerNumber(userArr[1]);
                    retVal.setPassword(userArr[2]);
                    retVal.setUserType(userArr[3]);
                    
                    break;
                }
            }
        }
        
        return retVal;
    }

    @Override
    public List<User> findAllUser() throws FileNotFoundException, IOException {
        List<String> userFileContent = Util.readFile("F:/bankfile/user.flat");
        List<User> retVal = new ArrayList<>();
        
        if(userFileContent.isEmpty()==false){
            User user;
            
            int ctr = 0;
            for(String fileContent:userFileContent){
                
                if(fileContent==null){
                    continue;
                }
                
                if(ctr==0){
                    ctr++;
                    continue;
                }
                
                String[] userArr = fileContent.split(DelimeterConstant.PIPE_WITH_ESCAPE.getValue());
                
                user = new User();
                user.setCustomerId(userArr[0]);
                user.setCustomerNumber(userArr[1]);
                user.setPassword(userArr[2]);
                user.setUserType(userArr[3]);
                
                retVal.add(user);
                
                ctr++;
            }
        }
        
        return retVal;
    }

    @Override
    public boolean isUserValid(String userId, String password) throws FileNotFoundException, IOException{
            List<String> userFileContent = Util.readFile("F:/bankfile/user.flat");
            
            if (userFileContent.isEmpty() == false) {
                
                int counter = 0;
                
                //Loop thru the records and check if user exist.
                for(String content:userFileContent){
                    
                    counter++;
                    //if counter is 1 then it is the file header
                    if(counter==1){
                        continue;
                    }
                    
                    String[] userArr;
                    userArr = content.split(DelimeterConstant.PIPE_WITH_ESCAPE.getValue());
                    
                    /*
                     * Checking of userId and password if matched then return 
                     * <code>true<code> which means authenticared user, otherwise
                     * false.
                     */
                    if(userArr[0].equalsIgnoreCase(userId) && userArr[2].equalsIgnoreCase(password)){
                        System.out.println("User Found! Returning true...");
                        return true;
                    }
                }
            }
            
        return false;
    }

    @Override
    public void deleteUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}