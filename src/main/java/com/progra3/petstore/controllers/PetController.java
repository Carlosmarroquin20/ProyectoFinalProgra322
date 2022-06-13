package com.progra3.petstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;

@RestController
@RequestMapping("/Pets")
public class PetController {
	
	@Autowired
	PetService service;
	
	@GetMapping()
	public List<Pet> findAll(){
		return service.listAll();
	}
	
	@GetMapping(value = "/{id}")
	public Pet findPet(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping()
	public Pet createPet(@RequestBody Pet pet) {
		pet.setId(null);
		return service.createPet(pet);
	}
	
	@PutMapping(value = "/{id}")
	public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		return service.updatePet(id, pet);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePet(@PathVariable Long id) {
		service.deletePet(id);
	}

}