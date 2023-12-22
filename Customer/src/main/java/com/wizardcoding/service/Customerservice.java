package com.wizardcoding.service;


import com.wizardcoding.CustomerRegistrationRequest;
import com.wizardcoding.CustomerRepo.CustomerRepository;
import com.wizardcoding.feignclent.ProductClient;
import com.wizardcoding.response.CustomerResponse;
import com.wizardcoding.response.ProductResponse;
import com.wizardcoding.enitity.Customer;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class Customerservice {
  private final CustomerRepository customerRepository;

  private  final ProductClient productClient;

  private  ModelMapper mapper;




    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phoneNumber(request.phoneNumber())
                .build();
         customerRepository.save(customer);

    }


    public CustomerResponse getCustomerById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        // Mapping the customer entity to a CustomerResponse using ModelMapper
        CustomerResponse customerResponse=mapper.map(customer,CustomerResponse.class);

        // Using a FeignClient (ProductClient) to retrieve product information associated with the customer ID

        ResponseEntity<ProductResponse> productResponse = productClient.getProductByCustomerId(id);
        // Setting the product response in the CustomerResponse object

        customerResponse.setProductResponse(productResponse.getBody());

        // // Returning the final CustomerResponse object

        return  customerResponse;


    }
}









