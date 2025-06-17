package com.example.dreamportaltests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DreamportalTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamportalTestsApplication.class, args);
	}

	@Bean
	public WebDriver webDriver() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		return new ChromeDriver();
	}
}
