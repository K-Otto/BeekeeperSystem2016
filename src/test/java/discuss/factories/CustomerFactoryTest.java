package discuss.factories;

import discuss.conf.factories.CustomerFactory;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Customer;
import discuss.domain.Person;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by student on 2015/09/13.
 */
public class CustomerFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl@gmail.com");
        Customer role = CustomerFactory.create("Milnerton",persons);
        Assert.assertEquals(role.getAddress(),"Milnerton");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Customer role = CustomerFactory.create("Melkbos", persons);
        Customer newBeekeeper = new Customer
                .Builder‭(role.getAddress())
                .copy(role)

                .build();
        Assert.assertEquals(newBeekeeper.getAddress(),"Melkbos");
        Assert.assertEquals(role.getAddress(),"Melkbos");

    }
}