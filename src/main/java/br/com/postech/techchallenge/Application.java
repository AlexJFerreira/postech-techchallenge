package br.com.postech.techchallenge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.info("logando com versão nova 2");
		SpringApplication.run(Application.class, args);
	}

}
