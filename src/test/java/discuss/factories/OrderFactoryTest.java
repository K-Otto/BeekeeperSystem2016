package discuss.factories;

/**
 * Created by student on 2016/04/07.
 */
import discuss.conf.factories.*;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class OrderFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling", beekeeper);
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Customer customers = CustomerFactory.create("",persons);
        Product product = ProductFactory.create(66.00, harvests);
        Salesman salesman = SalesmanFactory.create(10.00, persons);
        Order order = OrderFactory.create("March", customers, salesman);
        Assert.assertEquals(order.getSalesDate(), "March");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Product buckets = ProductFactory.create(66.00, harvests);
        Customer customers = CustomerFactory.create("",persons);
        Salesman salesman = SalesmanFactory.create(10.00, persons);
        Order order = OrderFactory.create("March", customers, salesman);
        Order newOrder = new Order
                .Builder(order.getSalesDate())
                .copy(order)
                .customers(customers)
                .salesman(salesman)
                .build();
        Assert.assertEquals(newOrder.getSalesDate(),"March");
        Assert.assertEquals(order.getSalesDate(), "March");

    }
}
