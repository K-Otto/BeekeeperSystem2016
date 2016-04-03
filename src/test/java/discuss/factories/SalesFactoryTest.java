package discuss.factories;
import discuss.conf.factories.*;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by student on 2015/09/13.
 */
public class SalesFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Customer customers = CustomerFactory.create("","","");
        Bucket buckets = BucketFactory.create( 66.00, harvests);

        Sales aa = SalesFactory.create("Olives", 22.22, buckets, customers);
        Assert.assertEquals(aa.getSalesDate(), "Olives");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Bucket buckets = BucketFactory.create( 66.00, harvests);
        Customer customers = CustomerFactory.create("","","");

        Sales role = SalesFactory.create("date", 22.00,buckets, customers);
        Sales newSubLocation = new Sales
                .Builder(role.getSalesDate())
                .copy(role)
                .price(22.00)
                .customers(customers)
                .buckets(buckets)
                .build();
        Assert.assertEquals(newSubLocation.getSalesDate(),"date");
        Assert.assertEquals(role.getSalesDate(), "date");

    }
}