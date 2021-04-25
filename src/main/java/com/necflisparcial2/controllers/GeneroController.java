package com.necflisparcial2.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.necflisparcial2.entities.Genero;
import com.necflisparcial2.repositories.GeneroRepository;

@RestController
@RequestMapping(value = "/genero")
public class GeneroController {

	@Autowired
	GeneroRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Genero> getListaGenero(){
		Iterable<Genero> listaGenero = repository.findAll();
		
		return (Collection<Genero>) listaGenero;
		}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Genero getGenero(@PathVariable(name = "id") Long id) {
		
		Optional<Genero> genero = repository.findById(id);
		Genero result = null;
		if(genero.isPresent()) {
			result = genero.get();
		}
		return result;	
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Genero createGenero(@RequestBody Genero genero ) {
		Genero nuevoGenero = repository.save(genero);
		return nuevoGenero;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteGenero(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);	
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Genero updateGenero(@PathVariable(name = "id") Long id, 
			@RequestBody Genero genero) {
		Optional<Genero> updGenero = repository.findById(id);
		if(updGenero.isPresent()) {
			Genero actual = updGenero.get(); 
			actual.setId(id);
			actual.setNombregenero(genero.getNombregenero());
			actual.setDescripciongenero(genero.getDescripciongenero());
			actual.setFechacreacion(genero.getFechacreacion());
			Genero updatedGenero = repository.save(actual);
			return updatedGenero;
		}
		return null;
	}
	
	
	
}
