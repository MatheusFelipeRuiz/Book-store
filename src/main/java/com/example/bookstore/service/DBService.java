package com.example.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.CategoryRepository;

@Service
@Profile("test")
public class DBService {
	@Autowired
	private CategoryRepository categoryRep;
	@Autowired
	private BookRepository bookRep;
	
	public void generateDataBase() {
		Category c1 = new Category(null, "TI", "Livros sobre tecnologia");
		Category c2 = new Category(null, "Animações","Livros de animes");
		Category c3 = new Category(null, "Matemática", "Livros sobre conceitos matemáticos");
		
		Book b1 = new Book(null, "Caelum: apostila Java", "Caelum", "Livro para entender os conceitos básicos de Java",
				c1);
		Book b2 = new Book(null,"Estrutura de dados Avançados: JavaScript","Loiane Groner","Livro sobre estruturas de dados em JS",c1);
		Book b3 = new Book(null, "Matemática Discreta","Sergio Negão", "Livro sobre matemática discreta", c3);
		Book b4 = new Book(null, "Matemática básica","Ferretto", "Livro sobre matemática básica", c3);
		
		c1.getListBooks().addAll(Arrays.asList(b1));

		categoryRep.saveAll(Arrays.asList(c1,c2,c3));
		bookRep.saveAll(Arrays.asList(b1,b2,b3,b4));

	}
	
}
