package br.com.controleponto.controledeponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.controleponto.controledeponto")
@EntityScan(basePackages = "br.com.controleponto.controledeponto.entity")

public class ControleDePontoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ControleDePontoApplication.class, args);
	}

}
