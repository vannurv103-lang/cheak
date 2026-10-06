package com.nit.beans;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="emp123")
public class Employee {
	@Id
	@SequenceGenerator(name="seq99",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq99")
  private int id;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String job;
	private double sal;
}
