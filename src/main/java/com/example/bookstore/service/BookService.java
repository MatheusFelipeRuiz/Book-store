package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRep;

	@Autowired
	private CategoryService categoryService;

	public Book findById(Integer id) {
		Optional<Book> obj = bookRep.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Livro não encontrado, ID: " + id + ", Livro: " + Book.class));
	}

	public List<Book> findAll() {
		return bookRep.findAll();
	}

	public List<Book> findAllByCategory(Integer id) {
		categoryService.findById(id);
		return bookRep.findAllByCategory(id);
	}

	public Book update(Integer id, Book obj) {
		Book newObj = findById(id);
		updateData(newObj, obj);
		return bookRep.save(newObj);
	}

	private void updateData(Book newObj, Book obj) {
		newObj.setText(obj.getText());
		newObj.setTitle(obj.getTitle());
		newObj.setAuthorName(obj.getAuthorName());
	}

	public Book save(Integer id, Book obj) {

		Category category = categoryService.findById(id);
		obj.setId(null);
		obj.setCategory(category);
		return bookRep.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		bookRep.deleteById(id);
	}
}
