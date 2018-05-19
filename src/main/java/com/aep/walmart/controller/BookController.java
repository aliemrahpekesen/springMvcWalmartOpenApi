package com.aep.walmart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aep.walmart.BookshopApplication;
import com.aep.walmart.domain.dto.Book;
import com.aep.walmart.service.BookService;

/**
 * @author aliemrahpekesen
 */
@Controller
public class BookController {

	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		logger.info("Loaded Book Categories are called by web page..");
		model.addAttribute("categories", BookshopApplication.bookCategories);
		return "bookList";
	}

	@RequestMapping(value = "/category/{subCategoryId}", method = RequestMethod.GET)
	public String getBooksOfSubCategory(Model model, @PathVariable(name = "subCategoryId") String subCategoryId,
			@RequestParam(required = false) Integer page) {
		if (page != null && page != 0) {
			logger.info("Pagination is activated and page " + page + " is called by web page..");
		}
		model.addAttribute("categories", BookshopApplication.bookCategories);
		model.addAttribute("subCagtegoryId", subCategoryId);

		List<Book> subCategoryBooks = bookService.getCategoryItems(subCategoryId);
		if (subCategoryBooks != null) {
			logger.info(subCategoryBooks.size() + " books of category with " + subCategoryId
					+ " id are returned to web page..");
			PagedListHolder<Book> pagedListHolder = new PagedListHolder<>(subCategoryBooks);
			pagedListHolder.setPageSize(20);

			if (page == null || page < 1 || page > pagedListHolder.getPageCount())
				page = 1;
			model.addAttribute("page", page);
			model.addAttribute("maxPages", pagedListHolder.getPageCount());

			if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
				pagedListHolder.setPage(0);
				model.addAttribute("subCategoryBooks", pagedListHolder.getPageList());
			} else if (page <= pagedListHolder.getPageCount()) {
				pagedListHolder.setPage(page - 1);
				model.addAttribute("subCategoryBooks", pagedListHolder.getPageList());
			}
		} else
			model.addAttribute("isCategoryEmpty", "Y");
		return "bookList";
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookById(Model model, @RequestParam int bookId) {
		model.addAttribute("book", bookService.getBookById(bookId));
		logger.info("Book " + bookId + " is returned to web page..");
		return "bookDetail";
	}
}
