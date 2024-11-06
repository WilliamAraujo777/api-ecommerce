package com.barbershop.barbershop.controllers;
import com.barbershop.barbershop.models.Product;
import com.barbershop.barbershop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProductById(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable String id) {
        productService.deleteProductById(id);
    }

}