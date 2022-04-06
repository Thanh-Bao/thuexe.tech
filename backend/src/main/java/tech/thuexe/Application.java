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
		userService.saveRole(new RoleEntity(null, Config.ROLE.USER.name()));
		userService.saveRole(new RoleEntity(null, Config.ROLE.SALE.name()));
		userService.saveRole(new RoleEntity(null, Config.ROLE.ROOT.name()));

		userService.saveUser(new UserEntity(null,"Jon Travolta", "john", "1234", new ArrayList<>()));
		userService.addRoleToUser("john", Config.ROLE.USER.name());
		userService.addRoleToUser("john", Config.ROLE.ROOT.name());
		};
	}
}
