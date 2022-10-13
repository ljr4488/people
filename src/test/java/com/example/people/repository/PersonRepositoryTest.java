package com.example.people.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.people.domain.dto.Birthday;
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

	@Test
	void findByBloodType() {
		givenPerson("martin", 10, "A", LocalDate.of(1991,8,15));
		givenPerson("davide", 9, "B", LocalDate.of(1992,7,15));
		givenPerson("davide", 8, "O", LocalDate.of(1993,6,15));
		givenPerson("davide", 7, "AB", LocalDate.of(1994,5,15));
		givenPerson("benny", 6, "A", LocalDate.of(1995,4, 15));

		List<Person> result = personRepository.findByBloodType("A");
		result.forEach(System.out::println);
	}

	@Test
	void findByBirthdayBetween() {
		givenPerson("martin", 10, "A", LocalDate.of(1991,2,10));
		givenPerson("davide", 9, "B", LocalDate.of(1991,8,16));
		givenPerson("davide", 8, "O", LocalDate.of(1993,6,15));
		givenPerson("davide", 7, "AB", LocalDate.of(1994,5,15));
		givenPerson("benny", 6, "A", LocalDate.of(1995,4, 15));

		List<Person> result = personRepository.findByMonthOfBirthday(2);
		result.forEach(System.out::println);
	}
	private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
		Person person = new Person(name, age, bloodType);
		person.setBirthday(new Birthday(birthday));
		personRepository.save(person);
	}
}
