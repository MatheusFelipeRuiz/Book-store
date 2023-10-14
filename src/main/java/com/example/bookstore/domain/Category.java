package com.example.bookstore.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity(name = "tbl_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_category")
	private Integer id;
	@NotEmpty(message = "Campo Nome é obrigatório")
	@Length(min = 3, max = 60, message = "Campo nome deve ter entre 10 e 60 caracteres" )
	@Column(name = "s_name_category")
	private String name;
	@NotEmpty(message = "Campo Descrição é obrigatório")
	@Length(min = 10, max = 100, message = "Campo descrição deve ter entre 10 e 100 caracteres")
	@Column(name = "s_description_category")
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Book> listBooks = new ArrayList<>();

	public Category() {

	}

	public Category(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getListBooks() {
		return listBooks;
	}

	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

}
