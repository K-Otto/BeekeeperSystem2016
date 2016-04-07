package discuss.factories;

import discuss.conf.factories.PersonFactory;
import discuss.conf.factories.SalesmanFactory;
import discuss.domain.Person;
import discuss.domain.Salesman;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by student on 2016/04/07.
 */
public class SalesmanFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Salesman beekeeper = SalesmanFactory.create(10.00, persons);
        Assert.assertEquals(beekeeper.getSalary‭‭(), 10.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");


        Salesman salesman = SalesmanFactory.create(10.00, persons);
        Salesman newSalesman = new Salesman
                .Builder‭(10.00)
                .copy(salesman)
                .persons(persons)
                .build();
        Assert.assertEquals(newSalesman.getSalary‭‭(),10.00);
        Assert.assertEquals(salesman.getSalary‭‭(), 10.00);

    }
}
