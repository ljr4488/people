package com.example.people.domain;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

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
	private LocalDate birth;
	private String job;
	@OneToOne(cascade = CascadeType.PERSIST)
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
