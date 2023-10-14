package com.example.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity(name = "tbl_book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_book")
	private Integer id;
	@Column(name = "s_title_book")
	@NotEmpty(message = "Campo Título é obrigatório")
	@Length(min = 3, max = 60, message = "Campo título deve possuir entre 3 a 60 caracteres")
	private String title;
	@Column(name = "s_authorname_book")
	private String authorName;
	@NotEmpty(message = "Campo texto é obrigatório")
	@Length(min = 10, max = 100, message = "Campo texto deve possuir entre 10 e 100 caracteres ")
	@Column(name = "s_text_book")
	private String text;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "i_category_category")
	private Category category;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String authorName, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.text = text;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

}
