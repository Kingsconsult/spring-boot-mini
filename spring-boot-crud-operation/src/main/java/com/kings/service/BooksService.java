package com.kings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kings.model.Books;
import com.kings.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}

	public Page<Books> getAllBooksWithPagination(@RequestParam int page) {
		return booksRepository.findAll(PageRequest.of(1, page));
	}

	public Page<Books> getAllBooksWithPaginationWIthOffset(@RequestParam int page, @RequestParam int offset) {
		return booksRepository.findAll(PageRequest.of(offset, page));
	}

	public List<Books> getAllBooksWithSorting(@RequestParam String field) {
		return booksRepository.findAll(Sort.by(Sort.Direction.DESC, field));
	}

	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	public void delete(int id) {
		booksRepository.deleteById(id);
	}

	public void update(Books books, int bookid) {
		Books book = booksRepository.findById(bookid).get();

		book.setBookname(books.getBookname());
		book.setAuthor(books.getAuthor());
		book.setPrice(books.getPrice());

		booksRepository.save(book);
	}

}
