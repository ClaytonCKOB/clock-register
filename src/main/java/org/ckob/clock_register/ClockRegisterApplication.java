package org.ckob.clock_register;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ClockRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClockRegisterApplication.class, args);
	}

}
