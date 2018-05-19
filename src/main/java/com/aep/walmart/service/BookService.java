package com.aep.walmart.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.aep.walmart.domain.dto.Book;
import com.aep.walmart.domain.dto.Category;
import com.aep.walmart.domain.dto.SearchAPIResponseEntity;
import com.aep.walmart.domain.dto.TaxonamyAPIResponseEntity;

/**
 * @author aliemrahpekesen
 */
@Service
public class BookService {

	private final Logger logger = LoggerFactory.getLogger(BookService.class);

	RestTemplate restTemplate = new RestTemplate();

	private List<Book> categoryBooks = null;

	@Value("${api.key}")
	private String API_KEY;

	@Value("${category.name}")
	private String QUERIED_CATEGORY_NAME;

	@Value("${category.get.url}")
	private String GET_CATEGORIES_URL;

	@Value("${search.api.url}")
	private String SEARCH_API_URL;

	public Category[] getCategories() {
		logger.info("Book Categories are being called from Walmart Open Api..");
		TaxonamyAPIResponseEntity categories = restTemplate.getForObject(
				GET_CATEGORIES_URL + "?apiKey=" + API_KEY + "&format=json", TaxonamyAPIResponseEntity.class);
		return categories.getCategories().stream()
				.filter(bookCategory -> bookCategory.getName().toUpperCase().equals(QUERIED_CATEGORY_NAME))
				.collect(Collectors.toList()).get(0).getChildren();
	}

	public List<Book> getCategoryItems(final String categoryId) {
		logger.info("Search is being proceed for category " + categoryId + "..");
		SearchAPIResponseEntity response = null;
		try {
			response = restTemplate.getForObject(SEARCH_API_URL + "?apiKey=" + API_KEY + "&categoryId=" + categoryId
					+ "&format=json&query=Books&responseGroup=full&numItems=25", SearchAPIResponseEntity.class);
			logger.info("Books of category are loaded to categoryBooks List..");
			this.categoryBooks = Arrays.stream(response.getItems()).collect(Collectors.toList());
			return categoryBooks;
		} catch (HttpClientErrorException ex) {
			logger.error(ex.getMessage());
			return null;
		}

	}

	public Book getBookById(final int bookId) {
		logger.info("Book, with " + bookId
				+ " bookId, is retrieved from existing categoryBooks List from memory to be displayed..");
		return this.categoryBooks.stream().filter(b -> b.getItemId() == bookId).findFirst().get();
	}

}
