package discuss.factories;

import discuss.conf.factories.*;
import discuss.domain.*;

import discuss.domain.SubLocation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HiveFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Hive hives = HiveFactory.create("sss", subLocations);
        Assert.assertEquals(hives.getHiveState(), "sss");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling", beekeeper);


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);


        Hive hives = HiveFactory.create("Fossil", subLocations);
        Assert.assertEquals(hives.getHiveState(), "Fossil");
        Hive newHives = new Hive
                .Builder("Water")

                .subLocations(subLocations)
                .build();
        Assert.assertEquals(newHives.getHiveState(),"Water");


    }
}