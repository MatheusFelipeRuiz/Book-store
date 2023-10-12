package com.example.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Category;
import com.example.bookstore.service.CategoryService;

@RestController
@RequestMapping("/categorias")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
}
