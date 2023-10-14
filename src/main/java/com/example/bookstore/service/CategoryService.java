package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookstore.domain.Category;
import com.example.bookstore.dtos.CategoryDTO;
import com.example.bookstore.repositories.CategoryRepository;
import com.example.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;

	public Category findById(@PathVariable Integer id) {
		Optional<Category> obj = categoryRep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado, ID:  " + id + " Categoria: " + Category.class.getName()));
	}

	public List<CategoryDTO> findAll() {
		List<Category> listCategorys = categoryRep.findAll();
		List<CategoryDTO> listCategoryDTO = listCategorys.stream().map((obj) -> new CategoryDTO(obj))
				.collect(Collectors.toList());
		return listCategoryDTO;

	}

	public Category save(Category obj) {
		obj.setId(null);
		return categoryRep.save(obj);
	}

	public Category update(Integer id, CategoryDTO obj) {
		Category category = new Category();
		category.setId(obj.getId());
		category.setName(obj.getName());
		category.setDescription(obj.getDescription());
		return categoryRep.save(category);
	}

	public void delete(Integer id) {
		findById(id);
		categoryRep.deleteById(id);
	}
}
