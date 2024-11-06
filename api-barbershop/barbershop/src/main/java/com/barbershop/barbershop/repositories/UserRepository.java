package com.barbershop.barbershop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.barbershop.barbershop.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findUserByEmail(String email);
}
