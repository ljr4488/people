package com.example.people.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;

import com.example.people.domain.dto.Birthday;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Getter
@Setter
@ToString(exclude = "phoneNumber")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private int age;
	@NonNull
	private String bloodType;
	private String hobby;
	private String address;
	@Valid
	@Embedded
	private Birthday birthday;
	private String job;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Block block;

	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		Person person = (Person)object;

		if(!person.getName().equals(this.getName())) {
			return false;
		}

		if(person.getAge() != this.getAge()) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		return (name + age).hashCode();
	}
	/*
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person{"+
				"id : " + id +
				", name : " + name +
				", age : " + age +
				"}";
	}
	*/
}
