package com.example.demopc1.service;

import com.example.demopc1.domain.Customer;
import com.example.demopc1.exception.ClassNotFound;
import com.example.demopc1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerServiceImpl implements CustomerService{
    CustomerRepository customerRepository;
    public  CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository =customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomerData() throws ClassNotFound {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int cusId) throws ClassNotFound {
        boolean result = false;
        if(customerRepository.findById(cusId).isEmpty()){
            throw new ClassNotFound();
        }else{
            customerRepository.deleteById(cusId);
            result = true;
        }
        return result;
    }

    @Override
    public List<Customer> getAllCustomerByProductName(String productName) throws ClassNotFound {
        if(customerRepository.findAllCustomerFromProductName(productName).isEmpty()){
            throw  new ClassNotFound();
        }
        return customerRepository.findAllCustomerFromProductName(productName);
    }



}
