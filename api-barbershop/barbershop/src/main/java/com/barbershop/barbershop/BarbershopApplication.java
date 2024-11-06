package com.barbershop.barbershop;

import com.barbershop.barbershop.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.barbershop.barbershop.models.User;
import com.barbershop.barbershop.repositories.UserRepository;

@SpringBootApplication
public class BarbershopApplication implements CommandLineRunner{

	private final UserRepository userRepository;

	@Autowired
	public BarbershopApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()){

			Address address = new Address(
					"Rua das Flores", // street
					"123",            // number
					"Apto 45",        // complement
					"Centro",         // neighborhood
					"São Paulo",      // city
					"SP",             // state
					"01000-000",      // postalCode
					"Brazil"          // country
					);

			userRepository.save(new User("William","J1WilliamMaisqueZika", "55555555", address));
		}
	}

}
