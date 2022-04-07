package tech.thuexe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
		userService.saveRole(new RoleEntity( Config.ROLE.USER.getValue()));
		userService.saveRole(new RoleEntity( Config.ROLE.SALE.getValue()));
		userService.saveRole(new RoleEntity( Config.ROLE.ROOT.getValue()));

		userService.saveUser(new UserEntity("Jon Travolta", "john", "1234", new ArrayList<>()));
		userService.addRoleToUser("john", Config.ROLE.USER.getValue());
		userService.addRoleToUser("john", Config.ROLE.ROOT.getValue());
		};
	}
}
