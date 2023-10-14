package com.example.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dtos.BookDTO;
import com.example.bookstore.service.BookService;

@RestController
@RequestMapping("/livros")
public class BookResource {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id){
		Book obj =  bookService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping()
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Integer id_category){
		List<Book> listBook = bookService.findAll(id_category);
		List<BookDTO> listBookDTO = listBook.stream().map((obj) -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listBookDTO);
	}
}
