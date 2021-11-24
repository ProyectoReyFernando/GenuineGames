package com.genuinegames.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "img")
	private String img;

	@Column(name = "category")
	private String category;

	@Column(name = "description")
	private String description;
	@Column(name = "punctuation")
	private Float punctuation;

	@OneToMany(mappedBy = "game")
	private Collection<Comments> comments;

	public Game() {
		super();
	}


	public Game(String name, String img, String category, String description, Float punctuation,
			Collection<Comments> comments) {
		super();
		this.name = name;
		this.img = img;
		this.category = category;
		this.img = img;
		this.description = description;
		this.punctuation = punctuation;
		this.comments = comments;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(Float punctuation) {
		this.punctuation = punctuation;
	}


	public Collection<Comments> getComments() {
		return comments;
	}


	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}
	

}
