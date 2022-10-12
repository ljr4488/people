package com.example.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.people.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
