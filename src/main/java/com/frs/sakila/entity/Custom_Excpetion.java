package com.frs.sakila.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Custom_Excpetion {

	private String message;
	private LocalDate time;
	
	public Custom_Excpetion(String message) {
		super();
		this.message = message;
		this.time = LocalDate.now();
	}
	
}
