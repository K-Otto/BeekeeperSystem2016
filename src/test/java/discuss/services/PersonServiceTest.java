package discuss.services;

import discuss.App;
import discuss.Services.PersonService;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Person;
import org.junit.Assert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by student on 2016/04/03.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PersonServiceTest  extends AbstractTestNGSpringContextTests {

    private long id;
    private Person personGlobal;

    @Autowired
    private PersonService service;

    @Test
    public void create() throws Exception {
        Person persons = PersonFactory
                .create("Karl", "Otto", "Karl@gmail.com");

        service.savePerson(persons.getFirstName(),
                persons.getLastName(),
                persons.getEmail());


        id = persons.getPersonId();
        personGlobal = persons;
        Assert.assertNotNull(persons);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";

        long longId = Long.parseLong(idtest);
        Person persons = service.getPerson(1);
        id = persons.getPersonId();
        personGlobal = service.getPerson(id);

        Assert.assertNotNull(personGlobal);

    }

}




