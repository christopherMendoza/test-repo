/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.impl;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.model.User;
import com.bank.service.UserService;
import java.util.List;

/**
 *
 * @author chris
 */
public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();
    
    @Override
    public void addUser(User user) throws Exception{
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception{
        userDao.updateUser(user);
    }

    @Override
    public User findUserById(String userId) throws Exception{
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findAllUser() throws Exception{
        return userDao.findAllUser();
    }

    @Override
    public boolean isUserExist(String userId, String password) throws Exception{
        return userDao.isUserValid(userId, password);
    }

    @Override
    public void deleteUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
