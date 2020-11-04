package com.sda.person.view;

import com.sda.person.dao.PersonDao;
import com.sda.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonView {
    private List<Person> personList = new ArrayList<>();

    @Autowired
    PersonDao dao;

    public void showPersons() {
        personList = dao.getAllPersons();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
