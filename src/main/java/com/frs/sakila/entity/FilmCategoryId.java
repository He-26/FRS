package com.frs.sakila.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
@EqualsAndHashCode
public class FilmCategoryId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="film_id")
	private Short filmId;
	
	@Column(name="category_id")
	private Byte categoryId;
	
	
}
