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
public class SuperFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Hive hives = HiveFactory.create("sss", subLocations);
        Super supers = SuperFactory.create("sss", hives);
        Assert.assertEquals(supers.getSuperState(), "sss");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Hive hives = HiveFactory.create("sss", subLocations);


        Super supers = SuperFactory.create("Fossil", hives);
        Super newSupers = new Super
                .Builder("Fossil")
                .copy(supers)
                .hives(hives)
                .build();
        Assert.assertEquals(newSupers.getSuperState(),"Fossil");
        Assert.assertEquals(supers.getSuperState(), "Fossil");

    }
}
