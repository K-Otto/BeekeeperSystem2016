package discuss.factories;

import discuss.conf.factories.PersonFactory;
import discuss.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class PersonFactoryTest {

    @Test
    public void testCreate() throws Exception {
        Person role = PersonFactory.create("Karl","Piet", "Karl@gmail.com");
        Assert.assertEquals(role.getFirstName(), "Karl");
    }

    @Test
    public void testUpdate() throws Exception {
        Person role = PersonFactory.create("Karl", "Otto", "Karl@gmail.com");
        Person newBeekeeper = new Person
                .Builder(role.getFirstName())
                .copy(role)
                .email("Karl@gmail.com")
                .build();
        Assert.assertEquals(newBeekeeper.getEmail(),"Karl@gmail.com");
        Assert.assertEquals(role.getLastName(),"Otto");

    }
}