package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}





//package com.example.demo;
//
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class DemoApplication implements CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setName("Ramesh Kai");
//		userRepository.save(user);
//
//		User user1 = new User();
//		user1.setName("Katile kelly");
//		userRepository.save(user1);
//
//		User user2 = new User();
//		user2.setName("Roman Roy");
//		userRepository.save(user2);
//
//		User user3 = new User();
//		user3.setName("Edith Choy");
//		userRepository.save(user3);
//
//	}
//}
