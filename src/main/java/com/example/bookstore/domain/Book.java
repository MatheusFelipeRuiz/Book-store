package com.example.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String authorName;
	private String text;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String authorName, String text) {
		super();
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.text = text;
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
