package com.barbershop.barbershop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field
    @NonNull
    private String name;

    @Field
    @NonNull
    private String email;

    @Field
    @NonNull
    private String password;

    @Field
    @NonNull
    private Address address;  // Address embutido no User
}