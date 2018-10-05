package com.gms;

import com.gms.domain.Account;
import com.gms.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GmsRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(GmsRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("count -> {}", repository.count());
		logger.info("Student id 10001 -> {}", repository.findById(1L));

//		logger.info("Inserting -> {}", repository.save(new Account("singh")));

//		logger.info("Update 10003 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

//		repository.deleteById(10002L);

		logger.info("count -> {}", repository.count());
		logger.info("All users -> {}", repository.findAll());
	}
}
