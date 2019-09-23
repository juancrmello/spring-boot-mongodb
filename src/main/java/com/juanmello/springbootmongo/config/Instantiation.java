package com.juanmello.springbootmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juanmello.springbootmongo.domain.User;
import com.juanmello.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User liu = new User(null, "Liu Kang", "liu@gmail.com");
		User kung = new User(null, "Kung Lao", "kung@gmail.com");
		User shang = new User(null, "Shang Tsung", "shang@gmail.com");
		
		userRepository.saveAll(Arrays.asList(liu, kung, shang));
	}

}
