package com.wizardcoding;

public record CustomerRegistrationRequest(

        String firstName,
        String lastName,
        String phoneNumber
) {
}
