package com.necflisparcial2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombregenero;
	@Column(name = "descripcion")
	private String descripciongenero;
	@Column(name = "fecha")
	private String fechacreacion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombregenero() {
		return nombregenero;
	}
	public void setNombregenero(String nombregenero) {
		this.nombregenero = nombregenero;
	}
	public String getDescripciongenero() {
		return descripciongenero;
	}
	public void setDescripciongenero(String descripciongenero) {
		this.descripciongenero = descripciongenero;
	}
	public String getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}	
	
	
	
}


