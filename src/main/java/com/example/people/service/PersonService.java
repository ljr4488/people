package com.example.people.service;

import com.example.people.domain.Block;
import com.example.people.domain.Person;
import com.example.people.repository.BlockRepository;
import com.example.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();

        return people.stream().filter(
                person -> person.getBlock() == null).collect(Collectors.toList());
    }
}
