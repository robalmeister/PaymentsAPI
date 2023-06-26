package io.github.robalmeister.payments.cashbill.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Personal {

    /**
     * First name
     */
    private String firstName;

    /**
     * Surname
     */
    private String surname;

    /**
     * Email address
     */
    private String email;

    /**
     * Country
     */
    private String country;

    /**
     * City
     */
    private String city;

    /**
     * Post code
     */
    private String postcode;

    /**
     * Street
     */
    private String street;

    /**
     * Building no
     */
    private String house;

    /**
     * Flat no
     */
    private String flat;

    /**
     * IPv4 address
     */
    private String ip;

}
