package com.wizardcoding.controller;

import com.wizardcoding.CustomerRegistrationRequest;
import com.wizardcoding.response.CustomerResponse;
import com.wizardcoding.service.Customerservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final Customerservice customerservice;

    // Define a method to handle HTTP POST requests for customer registration
    @PostMapping
    // Use @RequestBody annotation to map the request body to the CustomerRegistrationRequest object
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {

        // Call the registerCustomer method from the injected CustomerService
        customerservice.registerCustomer(customerRegistrationRequest);
    }


    @GetMapping("/{id}")
    private ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id) {
        CustomerResponse customer = customerservice.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);


    }
}

