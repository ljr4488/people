package com.example.people.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.people.domain.Person;

@SpringBootTest
class PersonRepositoryTest {
	@Autowired
	private PersonRepository personRepository;
	@Test
	void crud() {
		Person person = new Person();
		
		personRepository.save(person);
		
		person.setName("Lee");
		person.setAge(10);
		person.setBloodType("A");
		
		personRepository.save(person);
		//System.out.println(personRepository.findAll());
		
		List<Person> people = personRepository.findAll();
		
		assertThat(people.size()).isEqualTo(1);
		assertThat(people.get(0).getName()).isEqualTo("Lee");
		assertThat(people.get(0).getAge()).isEqualTo(10);
	}

	@Test
	void constructorTest() {
		Person person1 = new Person("KIM", 100, "A");
		Person person2 = new Person("KIM", 100, "A");

		System.out.println(person1.equals(person2));
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());

		Map<Person, Integer>map = new HashMap<>();

		map.put(person1, person1.getAge());

		System.out.println(map);
		System.out.println(map.get(person2));
	}
}
