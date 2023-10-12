package com.example.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRep;

	@Autowired
	private BookRepository bookRep;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "TI", "Livros sobre tecnologia");
		Book b1 = new Book(null, "Caelum: apostila Java", "Caelum", "Livro para entender os conceitos básicos de Java",
				c1);

		c1.getListBooks().addAll(Arrays.asList(b1));

		categoryRep.saveAll(Arrays.asList(c1));
		
		bookRep.saveAll(Arrays.asList(b1));
	}

}
