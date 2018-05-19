package com.aep.walmart.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.aep.walmart.domain.dto.Category;

/**
 * @author aliemrahpekesen
 */
@RunWith(SpringRunner.class)
public class BookServiceTests {

	@Mock
	private BookService bookService;

	@Before
	public void setUp() {
		Category c = new Category();
		c.setId("1000");
		c.setName("Hobbies");
		Category[] categories = new Category[] { c };
		Mockito.when(bookService.getCategories()).thenReturn(categories);
	}

	@Test
	public void checkCategories() {
		Category c = new Category();
		c.setId("1000");
		c.setName("Hobbies");
		Category[] response = bookService.getCategories();
		assertEquals(true, response.length > 0);
		assertThat(response[0].getId()).isEqualTo(c.getId());

	}

}
