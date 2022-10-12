package com.example.fastcampus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fastcampus.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
