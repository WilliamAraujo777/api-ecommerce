package com.barbershop.barbershop.services;

import com.barbershop.barbershop.models.Product;
import com.barbershop.barbershop.models.ShoppingCart;
import com.barbershop.barbershop.models.CartItem;
import com.barbershop.barbershop.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService; // Para verificar produtos ao adicionar ao carrinho

    // Obtém o carrinho do usuário
    public ShoppingCart getCartByUserId(String userId) {
        return shoppingCartRepository.findByUserId(userId)
                .orElseGet(() -> new ShoppingCart(userId)); // Cria um novo carrinho se não existir
    }

    // Adiciona um item ao carrinho
    public ShoppingCart addItemToCart(String userId, String productId, Integer quantity) {
        ShoppingCart cart = getCartByUserId(userId);

        Optional<Product> productOpt = productService.getProductById(productId); // Busca produto

        if (productOpt.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        Product product = productOpt.get();

        // Verifica se o item já está no carrinho
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            // Atualiza a quantidade do item existente
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            item.setSubtotal(item.getUnitPrice() * item.getQuantity());
        } else {
            // Adiciona um novo item ao carrinho
            CartItem newItem = new CartItem(productId, product.getName(), product.getPrice(), quantity);
            newItem.setSubtotal(newItem.getUnitPrice() * quantity);
            cart.getItems().add(newItem);
        }

        // Atualiza o total do carrinho
        updateCartTotal(cart);
        return shoppingCartRepository.save(cart);
    }

    // Remove um item do carrinho
    public ShoppingCart removeItemFromCart(String userId, String productId) {
        ShoppingCart cart = getCartByUserId(userId);

        cart.getItems().removeIf(item -> item.getProductId().equals(productId));

        updateCartTotal(cart);
        return shoppingCartRepository.save(cart);
    }

    // Limpa o carrinho
    public void clearCart(String userId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.getItems().clear();
        cart.setTotalAmount(0.0);
        shoppingCartRepository.save(cart);
    }

    // Atualiza o total do carrinho
    private void updateCartTotal(ShoppingCart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
        cart.setTotalAmount(total);
    }
}