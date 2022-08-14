package com.tamara.tamarapaymentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TamaraPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamaraPaymentApiApplication.class, args);
	}

}
