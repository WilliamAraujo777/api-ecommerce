package com.barbershop.barbershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    @Field
    private String userId;

    @Field
    private List<CartItem> items;

    @Field
    private Double totalAmount;

    @Field
    private String status;//("PENDING", "COMPLETED", "CANCELLED")

    @Field
    private LocalDateTime orderDate;

}
