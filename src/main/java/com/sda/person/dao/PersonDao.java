package com.sda.person.dao;

import com.sda.person.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public interface PersonDao {
    List<Person> getAllPersons();

    Person getPersonById(int PersonId);

    Person addPerson(Person Person);

    Person removePerson(Person Person);

    Person modifyPerson(int PersonId, Person Person);

    List<Person> getByFirstName(String firstName);

    List<Person> getByLastName(String lastName);

    List<Person> getByAgeBetween(int min, int max);
}