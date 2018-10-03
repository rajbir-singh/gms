package com.gms;

import com.gms.account.Account;
import com.gms.account.AccountRepository;
import com.gms.student.Student;
import com.gms.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("count -> {}", repository.count());
		logger.info("Student id 10001 -> {}", repository.findById(1L));

		logger.info("Inserting -> {}", repository.save(new Account("John")));

//		logger.info("Update 10003 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

//		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}
