package com.barbershop.barbershop.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor // Construtor para todos os atributos exceto `id`
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    @Field("name")
    @NonNull
    private String name;

    @Field("description")
    @NonNull
    private String description;

    @Field("price")
    @NonNull
    private Double price;

    @Field("qtd")
    @NonNull
    private Integer qtd;

    @Field("category")
    private String category;
}