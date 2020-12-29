package com.toystore.ecomm.ptms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {
											"com.toystore.ecomm.ptms.daorepo.repository",
											"com.toystore.ecomm.ptms.daorepo.model", 
											"com.toystore.ecomm.ptms.daorepo.factory"
   										   })
public class PtmsDaoRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtmsDaoRepoApplication.class, args);
	}

}
