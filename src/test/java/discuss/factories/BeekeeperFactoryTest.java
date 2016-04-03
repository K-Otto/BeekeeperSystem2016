package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;

import discuss.conf.factories.PersonFactory;
import discuss.domain.Beekeeper;

import discuss.domain.Person;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Created by student on 2015/09/13.
 */
public class BeekeeperFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
       Assert.assertEquals(beekeeper.getSalary‭‭(),10.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");


        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Beekeeper newBeekeeper = new Beekeeper
                .Builder‭(10.00)
                .copy(beekeeper)
                .persons(persons)
                .build();
        Assert.assertEquals(newBeekeeper.getSalary‭‭(),10.00);
        Assert.assertEquals(beekeeper.getSalary‭‭(), 10.00);

    }
}