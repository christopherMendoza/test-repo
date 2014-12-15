/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.model.User;
import java.util.List;

/**
 *
 * @author chris
 */
public interface UserService {
    public void addUser(User user)throws Exception;
    public void updateUser(User user)throws Exception;
    public void deleteUser(User user)throws Exception;
    public User findUserById(String userId)throws Exception;
    public List<User> findAllUser()throws Exception;
    public boolean isUserExist(String userId,String password)throws Exception;
}
