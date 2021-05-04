package com.edf.ltihelloworld.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coche implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String modelo;
	@NotEmpty
	private String marca;
	@Positive
	private Double precio;
	@Positive
	private int numPuertas;
	@Positive
	private int cv;
	@NotNull
	private double km;

}
