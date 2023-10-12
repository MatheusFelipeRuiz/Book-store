package com.example.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;
	
	public Category findById(@PathVariable Integer id){
		Optional<Category> obj = categoryRep.findById(id);
		return obj.orElse(null);
	}

}
