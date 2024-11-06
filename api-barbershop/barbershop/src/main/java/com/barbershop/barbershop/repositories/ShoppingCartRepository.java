package com.barbershop.barbershop.repositories;

import com.barbershop.barbershop.models.Product;
import com.barbershop.barbershop.models.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>{
}
