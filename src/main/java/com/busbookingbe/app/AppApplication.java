package com.busbookingbe.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url= "https:bookingManagement1.com"),
		@Server(url= "https:bookingManagement2.com") },
		info = @Info(title = "Booking Methods", version = "v1",
		description = "CRUD Operations in Bus Booking"))
public class AppApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
