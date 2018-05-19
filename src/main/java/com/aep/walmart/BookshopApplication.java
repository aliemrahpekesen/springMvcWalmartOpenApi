package com.aep.walmart;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aep.walmart.domain.dto.Category;
import com.aep.walmart.service.BookService;

/**
 * @author aliemrahpekesen
 */
@SpringBootApplication
public class BookshopApplication {

	private final Logger logger = LoggerFactory.getLogger(BookshopApplication.class);

	public static Category[] bookCategories;

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

	@PostConstruct
	private void PostConstruct() {
		logger.info("Fetching book categories..");
		bookCategories = bookService.getCategories();
		logger.info("Book Categories are loaded..");
	}
}
