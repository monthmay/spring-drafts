package com.xyz.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UploadingFilesApplication {

	@Bean
	public HikariDataSource configDB() {
		HikariConfig conf = new HikariConfig();
		conf.setDriverClassName("org.postgresql.Driver");
		conf.setJdbcUrl("jdbc:postgresql://localhost:5432/test_db?useTimezone=true&serverTimezone=UTC");
		conf.setUsername("example");
		conf.setPassword("example");
		return new HikariDataSource(conf);
	}

	public static void main(String[] args) {
		SpringApplication.run(UploadingFilesApplication.class, args);
	}

}
