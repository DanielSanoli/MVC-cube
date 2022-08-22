package br.com.metasix.mvcube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MvccubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvccubeApplication.class, args);
		
		String encode = new BCryptPasswordEncoder().encode("1234");
		System.out.println(encode);
	}

}

