package com.wizardcoding.CustomerRepo;

import com.wizardcoding.enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
