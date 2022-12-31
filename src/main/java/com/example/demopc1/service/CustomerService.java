package com.example.demopc1.service;

import com.example.demopc1.domain.Customer;
import com.example.demopc1.exception.ClassNotFound;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomerData() throws ClassNotFound;
    public boolean deleteCustomer(int cusId) throws ClassNotFound;
    List<Customer> getAllCustomerByProductName(String productName) throws ClassNotFound;
}
