package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookstore.domain.Category;
import com.example.bookstore.dtos.CategoryDTO;
import com.example.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;

	public Category findById(@PathVariable Integer id) {
		Optional<Category> obj = categoryRep.findById(id);
		return obj.orElseThrow(() -> new com.example.bookstore.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado, ID:  " + id + " Categoria: " + Category.class.getName()));
	}

	
	public List<CategoryDTO> findAll(){
		List<Category> listCategorys = categoryRep.findAll();
		List<CategoryDTO> listCategoryDTO = listCategorys.stream().map((obj) -> new CategoryDTO(obj)).collect(Collectors.toList());
		return listCategoryDTO;
		
	}
}
