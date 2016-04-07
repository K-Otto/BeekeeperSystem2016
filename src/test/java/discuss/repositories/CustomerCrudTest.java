package discuss.repositories;

import discuss.App;
import discuss.conf.factories.CustomerFactory;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Customer;
import discuss.domain.Person;
import discuss.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;




import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class CustomerCrudTest extends AbstractTestNGSpringContextTests{

    private long id;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void create() throws Exception {
        Person persons = PersonFactory.create("Karl", "Otto","karl@gmail.com");
        Customer customers = CustomerFactory.create("karl",persons);

        repository.save(customers);
        id=customers.getCustomerID();
        Assert.assertNotNull(customers.getCustomerID());
        System.out.println(customers.getCustomerID());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Customer role = repository.findOne(id);

        Assert.assertEquals("karl",role.getAddress());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Customer role = repository.findOne(id);
        Customer newrole = new Customer
                .Builder‭(role.getAddress())
                .copy(role)

                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Customer savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getAddress(),"karl1256@gmail.com");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer role = repository.findOne(id);
        repository.delete(role);
        Customer deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
