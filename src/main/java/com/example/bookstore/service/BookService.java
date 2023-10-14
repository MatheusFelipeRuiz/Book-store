package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Livro não encontrado, ID: " + id + ", Livro: " + Book.class) );
	}
	
	public List<Book> findAll(Integer id){
		categoryService.findById(id);
		return bookRep.findAllByCategory(id);
	}
}
