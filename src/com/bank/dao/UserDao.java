/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.User;
import java.util.List;

/**
 *
 * @author chris
 */
public interface UserDao {
    public void addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(User user) throws Exception;
    public User findUserById(String userId)throws Exception;
    public List<User> findAllUser()throws Exception;
    public boolean isUserValid(String userId,String password)throws Exception;
}
