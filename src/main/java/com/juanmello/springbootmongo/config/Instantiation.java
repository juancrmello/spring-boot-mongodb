package com.juanmello.springbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juanmello.springbootmongo.domain.Post;
import com.juanmello.springbootmongo.domain.User;
import com.juanmello.springbootmongo.dto.AuthorDTO;
import com.juanmello.springbootmongo.repository.PostRepository;
import com.juanmello.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User liu = new User(null, "Liu Kang", "liu@gmail.com");
		User kung = new User(null, "Kung Lao", "kung@gmail.com");
		User shang = new User(null, "Shang Tsung", "shang@gmail.com");
		
		userRepository.saveAll(Arrays.asList(liu, kung, shang));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(liu));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(liu));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		liu.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(liu);
	}

}
