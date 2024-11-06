package com.barbershop.barbershop.controllers;

import com.barbershop.barbershop.models.User;
import com.barbershop.barbershop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    // Atualizar um usuário existente baseado no ID
    @PutMapping("{id}")
    public User updateUserById(@PathVariable String id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    // Deletando um usuário baseado no id
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
    }

}