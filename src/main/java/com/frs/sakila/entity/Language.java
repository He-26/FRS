package com.frs.sakila.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
@Table(name="language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private Byte languageId;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "language")
	private Set<Film> films;

	@OneToMany(mappedBy = "originalLanguage")
	private Set<Film> originalLanguageFilms;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastUpdate;
}
