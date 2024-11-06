package com.barbershop.barbershop.services;

import com.barbershop.barbershop.models.Product;
import com.barbershop.barbershop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    //Buscar todos os dados
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Inserindo
    public Product insertProduct(Product product){
        return productRepository.save(product);
    }

    //Atualizando um produto baseado no ID
    public Product updateProductById(String id, Product updatedProduct) {
        // Verifica se o produto com o ID fornecido existe
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        // Atualiza os dados do produto
        Product product = existingProduct.get();
        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setQtd(updatedProduct.getQtd());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());


        return productRepository.save(product);
    }

    // Deletando um produto baseado no id
    public void deleteProductById(String id) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new IllegalArgumentException("produto não encontrado.");
        }

        productRepository.delete(existingProduct.get()); // Deleta o produto com o id fornecido
    }


}