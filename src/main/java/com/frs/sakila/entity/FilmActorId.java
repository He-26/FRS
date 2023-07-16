package com.frs.sakila.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//for ocmposite key
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class FilmActorId implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Column(name = "actor_id")
	private Short actorId;
	
	@Column(name = "film_id")
	private Short filmId;
	
}
