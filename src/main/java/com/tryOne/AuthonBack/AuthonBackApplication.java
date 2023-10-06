package com.tryOne.AuthonBack;

import com.tryOne.AuthonBack.DAO.security.RoleDao;
import com.tryOne.AuthonBack.DAO.security.UserDao;
import com.tryOne.AuthonBack.entity.security.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthonBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthonBackApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(RoleDao roleDao, UserDao userDao, PasswordEncoder passwordEncoder){
//		return (args) -> {
//			roleDao.addARoll(new Role(1,"ROLE_PEN"));
//		};
//	}
}
