/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.model.Customer;
import java.util.List;

/**
 *
 * @author chris
 */
public interface CustomerService {
    public List<Customer> findAllCustomer() throws Exception;
    public Customer findCustomerByCustomerId(String customerId) throws Exception;
    public Customer findCustomerByName(String customerName) throws Exception;
    public void AddCustomer()throws Exception;
    public void updateCustomer(Customer customer)throws Exception;
    public void deleteCustomer(String customerId) throws Exception;
}
