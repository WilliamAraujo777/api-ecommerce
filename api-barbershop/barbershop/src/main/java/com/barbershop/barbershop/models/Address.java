package com.barbershop.barbershop.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document()
public class Address {
    @Field("street")
    private String street;

    @Field("number")
    private String number;
    
    @Field("complement")
    private String complement;
    
    @Field("neighborhood")
    private String neighborhood;

    @Field("city")
    private String city;
    
    @Field("state")
    private String state;
    
    @Field("postal_code")
    private String postalCode;
    
    @Field("country")
    private String country;
}