package br.com.core.memoteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MemotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemotecaApplication.class, args);
	}

}
