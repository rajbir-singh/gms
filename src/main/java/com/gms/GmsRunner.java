package com.gms;

import com.gms.repository.AccountRepository;
import com.gms.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.gms.accountRepository")
@SpringBootApplication
public class GmsRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(GmsRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("count -> {}", accountRepository.count());

		logger.info("addresses -> {}", addressRepository.findAll());

		logger.info("name -> {}", accountRepository.findAll());

		logger.info("Student id 10001 -> {}", accountRepository.findById(1L));

//		logger.info("Inserting -> {}", accountRepository.save(new Account("singh")));

//		logger.info("Update 10003 -> {}", accountRepository.save(new Student(10001L, "Name-Updated", "New-Passport")));

//		accountRepository.deleteById(10002L);

		logger.info("count -> {}", accountRepository.count());
		logger.info("All users -> {}", accountRepository.findAll());
	}
}
