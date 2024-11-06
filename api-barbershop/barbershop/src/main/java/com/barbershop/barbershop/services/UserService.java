package com.barbershop.barbershop.services;

import com.barbershop.barbershop.models.User;
import com.barbershop.barbershop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //Buscar todos os dados
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Inserindo
    public User insertUser(User user){
        //Verifico se já existe algum usuário cadastrado
        Optional<User> existingUser = userRepository.findUserByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("O e-mail já está em uso.");
        }

        return userRepository.save(user);
    }

    // Atualizando um usuário baseado no ID
    public User updateUserById(String id, User updatedUser) {
        // Verifica se o usuário com o ID fornecido existe
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        // Atualiza os dados do usuário
        User user = existingUser.get();
        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());
        user.setAddress(updatedUser.getAddress());  // Atualiza o endereço se necessário

        return userRepository.save(user);
    }

    // Deletando um usuário baseado no id
    public void deleteUserById(String id) {
        // Verifica se o usuário com o id fornecido existe
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        userRepository.delete(existingUser.get()); // Deleta o usuário com o id fornecido
    }


}