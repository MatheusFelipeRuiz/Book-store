package com.example.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dtos.BookDTO;
import com.example.bookstore.service.BookService;

@RestController
@RequestMapping("/livros")
public class BookResource {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book obj = bookService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping()
	public ResponseEntity<List<BookDTO>> findAllByCategory(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_category) {
		List<Book> listBook = bookService.findAllByCategory(id_category);
		List<BookDTO> listBookDTO = listBook.stream().map((obj) -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listBookDTO);
	}

	@GetMapping("/")
	public ResponseEntity<List<BookDTO>> findAll() {
		List<Book> listBook = bookService.findAll();
		List<BookDTO> listBookDTO = listBook.stream().map((obj) -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listBookDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj) {
		Book book = bookService.update(id, obj);
		return ResponseEntity.ok().body(book);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj) {
		Book book = bookService.update(id, obj);
		return ResponseEntity.ok().body(book);
	}

	@PostMapping()
	public ResponseEntity<Book> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_category,
			@RequestBody Book obj) {
		Book book = bookService.save(id_category, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
