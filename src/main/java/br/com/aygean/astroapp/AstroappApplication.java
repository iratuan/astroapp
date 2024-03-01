package br.com.aygean.astroapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AstroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstroappApplication.class, args);
	}

}
