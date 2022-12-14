package com.example.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.people.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value="select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);
}
