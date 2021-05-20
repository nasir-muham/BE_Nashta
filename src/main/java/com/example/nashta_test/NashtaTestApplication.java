package com.example.nashta_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.nashta_test.properties.FileStorageProperty;


@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperty.class
})
public class NashtaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NashtaTestApplication.class, args);
	}

}
