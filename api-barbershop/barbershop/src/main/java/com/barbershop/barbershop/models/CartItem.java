package com.barbershop.barbershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private String productId;
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private Double subtotal; // unitPrice * quantity


}
