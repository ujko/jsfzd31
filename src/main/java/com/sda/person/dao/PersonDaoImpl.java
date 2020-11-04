package com.sda.person.dao;

import com.sda.person.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDaoImpl implements PersonDao {

    private Map<Integer, Person> PersonMap;

    public PersonDaoImpl() {
        PersonMap = new HashMap<>();
        createPersons();
    }

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(PersonMap.values());
    }

    @Override
    public Person getPersonById(int PersonId) {
        return PersonMap.get(PersonId);
    }

    @Override
    public Person addPerson(Person Person) {
        int PersonId = PersonMap.keySet().stream().mapToInt(x -> x).max().orElse(0) + 1;
        Person.setPersonId(PersonId);
        PersonMap.put(Person.getPersonId(), Person);
        return Person;
    }

    @Override
    public Person removePerson(Person Person) {
        PersonMap.remove(Person.getPersonId());
        return Person;
    }

    @Override
    public Person modifyPerson(int PersonId, Person Person) {
        Person.setPersonId(PersonId);
        PersonMap.put(PersonId, Person);
        return Person;
    }

    @Override
    public List<Person> getByFirstName(String firstName) {
        return getAllPersons()
                .stream()
                .filter(x -> x.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getByLastName(String lastName) {
        return getAllPersons()
                .stream()
                .filter(x -> x.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getByAgeBetween(int min, int max) {
        LocalDate now = LocalDate.now();
        return getAllPersons().stream().filter(x -> {
            int years = Period.between(x.getBirthDate(), now).getYears();
            return (years >= min & years <= max);
        }).collect(Collectors.toList());
    }

    private void createPersons() {
        Person u1 = new Person();
        u1.setFirstName("Pawel");
        u1.setLastName("Nowak");
        u1.setBirthDate(LocalDate.of(1999, 05, 05));

        Person u2 = new Person();
        u2.setFirstName("Anna");
        u2.setLastName("Kowalska");
        u2.setBirthDate(LocalDate.of(2002, 02, 01));

        Person u3 = new Person();
        u3.setFirstName("Kasia");
        u3.setLastName("Andrzejewska");
        u3.setBirthDate(LocalDate.of(1975, 04, 15));

        Person u4 = new Person();
        u4.setFirstName("Karolina");
        u4.setLastName("Lesczynska");
        u4.setBirthDate(LocalDate.of(1993, 01, 23));

        Person u5 = new Person();
        u5.setFirstName("Anna");
        u5.setLastName("Nowak");
        u5.setBirthDate(LocalDate.of(1998, 12, 24));

        addPerson(u1);
        addPerson(u2);
        addPerson(u3);
        addPerson(u4);
        addPerson(u5);
    }
}

