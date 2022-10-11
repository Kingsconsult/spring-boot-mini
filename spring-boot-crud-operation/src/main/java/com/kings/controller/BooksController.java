package com.kings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kings.model.Books;
import com.kings.service.BooksService;

@RestController
@RequestMapping("/books")

public class BooksController {

	@Autowired
	BooksService booksService;

	
	@GetMapping()
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("sorting")
	private List<Books> getAllBooksWithSorting(@RequestParam String sortBy) {
		return booksService.getAllBooksWithSorting(sortBy);
	}

	@GetMapping("pagination")
	private Page<Books> getALlBooksWithPagination(@RequestParam int page) {
		return booksService.getAllBooksWithPagination(page);
	}

	@GetMapping("pagination/offset")
	private Page<Books> getALlBooksWithPaginationWithOffset(@RequestParam int page, @RequestParam int offset) {
		return booksService.getAllBooksWithPaginationWIthOffset(offset, page);
	}

	@GetMapping("{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}
	

	@PostMapping()
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

	@DeleteMapping("{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}

	@PutMapping("{bookid}")
	private Books update(@RequestBody Books books, @PathVariable("bookid") int bookid) {
		booksService.update(books, bookid);
		return booksService.getBooksById(bookid);
	}
}
