package com.barbershop.barbershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "shopping_carts")
public class ShoppingCart {

    @Id
    private String id;

    @Field
    private String userId; // Relacionado ao usuário

    @Field
    private List<CartItem> items = new ArrayList<>(); // Lista de itens no carrinho

    @Field
    private Double totalAmount; // Total do carrinho, calculado dinamicamente

}
