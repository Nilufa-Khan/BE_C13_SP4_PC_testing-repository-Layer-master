package com.example.demopc1.repository;


import com.example.demopc1.domain.Customer;
import com.example.demopc1.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Product product;
    private Customer customer;

    @BeforeEach
    public void setUp(){
        product = new Product(12,"Sumsung","galaxy2");
        customer = new Customer(25,"Mikita","56632322",product);
    }

    @AfterEach
    public void tearDown(){
        product = null;
        customer = null;
        // customerRepository.deleteAll();
    }
    @Test
    @DisplayName("Test case for saving customer object")
    void givenCustomerToSaveShouldReturnSavedCustomer(){
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustId(),customer1.getCustId());
    }

    @Test
    @DisplayName("Test case for deleting customer object")
    public void givenCustomerToDeleteShouldDeleteCustomer() {
      Product  product2 = new Product(1,"Nokia","noki34");
        Customer customer2 = new Customer(2,"Dhiraj","7732322",product2);

        customerRepository.insert(customer2);
        Customer customer1 = customerRepository.findById(customer.getCustId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustId()));

    }

    @Test
    @DisplayName("Test case for retrieving all the  customer object")
    public void givenCustomerReturnAllCustomerDetails() {

        //customerRepository.insert(customer);
        Product product1 = new Product(8,"iphone14","op2");
        Customer customer1 = new Customer(8,"charu","965322",product1);
        customerRepository.insert(customer1);

        List<Customer> list = customerRepository.findAll();
        assertEquals(6, list.size());
        assertEquals("John", list.get(1).getCustName());

    }

}
