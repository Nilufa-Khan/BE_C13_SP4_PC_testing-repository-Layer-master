package com.example.demopc1.controller;


import com.example.demopc1.domain.Customer;
import com.example.demopc1.exception.ClassNotFound;
import com.example.demopc1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerdata/v1")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/postdata")
    public ResponseEntity<?> saveCustomerData(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);

    }

    @GetMapping("/getdata")
    public ResponseEntity<?> fetchAllCustomer() throws Exception {
        return new ResponseEntity<>(customerService.getAllCustomerData(), HttpStatus.FOUND);
    }


    @DeleteMapping("/deleteData/{custId}")
    public ResponseEntity<?> deleteData(@PathVariable int custId) throws ClassNotFound, Exception {
        return new ResponseEntity<>(customerService.deleteCustomer(custId), HttpStatus.OK);
    }


    @GetMapping("/getDataByProductname/{productName}")
    public ResponseEntity<?> getDataByCity(@PathVariable String productName) throws ClassNotFoundException,Exception{
        return new ResponseEntity<>(customerService.getAllCustomerByProductName(productName),HttpStatus.FOUND);
    }
}
