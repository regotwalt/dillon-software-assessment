package com.hoopladigital.mapper;

import com.hoopladigital.bean.Person;
import com.hoopladigital.bean.Pet;

class MapperTestHelper {

	static final String over50name = "123456789012345678901234567890123456789012345678901";

	static Person createValidPerson(final boolean withId) {
		final Person person = new Person();
		person.setFirstName("John");
		person.setMiddleName("James");
		person.setLastName("Doe");
		if (withId) person.setId(1L);
		return person;
	}

	static Pet createValidPet(final boolean withId) {
		final Pet pet = new Pet();
		pet.setPersonId(1L);
		pet.setName("Scruffy");
		if (withId) pet.setId(1L);
		return pet;
	}

}
