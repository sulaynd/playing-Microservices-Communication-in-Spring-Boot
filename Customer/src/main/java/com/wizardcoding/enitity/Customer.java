package com.wizardcoding.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Mark the class as a Data class using Lombok annotations
@Data
// Use Lombok annotations to automatically generate a Builder pattern
@Builder
@AllArgsConstructor
@NoArgsConstructor
// Mark the class as an entity for JPA (Java Persistence API)
@Entity
public class Customer {
    @Id
    // Define a sequence generator for the primary key
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    // Generate a value for the primary key using the specified strategy and generator
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
//Define a field to store the customer's ID
    private Long id;

  // Define fields to store customer information
    private  String  firstName;
    private String lastName;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
