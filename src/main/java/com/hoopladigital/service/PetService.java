package com.hoopladigital.service;

import com.hoopladigital.bean.Pet;
import com.hoopladigital.mapper.PetMapper;

import javax.inject.Inject;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class PetService {

	private final PetMapper petMapper;

	@Inject
	public PetService(final PetMapper petMapper) {
		this.petMapper = petMapper;
	}

	public List<Pet> getPetList() {
		return petMapper.getPetList();
	}

	public Pet getPetById(Long id) {
		return petMapper.getPetById(id);
	}

	public Pet createPet(Pet pet) {
		if (pet == null) return null;
		try {
			petMapper.createPet(pet);
		}
		catch (PersistenceException pe) {
			return null;
		}
		return pet;
	}

	public Pet updatePet(Pet pet) {
		if (pet == null) return null;
		try {
			petMapper.updatePet(pet);
		}
		catch (PersistenceException pe) {
			return null;
		}
		return pet;
	}

	public boolean deletePet(Pet pet) {
		if (pet == null) return false;
		try {
			final int numberDeleted = petMapper.deletePet(pet);
			// Future: Log WARN if numberDeleted>1 - would be unexpected
			return numberDeleted > 0;
		}
		catch (PersistenceException pe) {
			return false;
		}
	}

}
