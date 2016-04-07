package discuss.factories;

import discuss.conf.factories.*;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/13.
 */
public class ProductFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);

        Product hives = ProductFactory.create(66.00, harvests);
        Assert.assertEquals(hives.getTotalStock(), 66.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);


        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);


        Product buckets = ProductFactory.create(66.00, harvests);
        Product newProduct = new Product
                .Builder(buckets.getTotalStock())

                .copy(buckets)
                .harvests(harvests)
                .build();
        Assert.assertEquals(newProduct.getTotalStock(), 66.00);
        Assert.assertEquals(buckets.getTotalStock(), 66.00);

    }
}

