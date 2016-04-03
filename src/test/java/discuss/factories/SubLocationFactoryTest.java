package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.PersonFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Location;
import discuss.domain.Person;
import discuss.domain.SubLocation;
import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SubLocationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );
        SubLocation location = SubLocationFactory.create("Olives", locations);
        Assert.assertEquals(location.getSubLocationName(), "Olives");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling",beekeeper );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        SubLocation newSubLocation = new SubLocation
                .Builder("Fossil")
                .copy(subLocations)
                .locations(locations)
                .build();
        Assert.assertEquals(newSubLocation.getSubLocationName(),"Fossil");
        Assert.assertEquals(subLocations.getSubLocationName(), "Fossil");

    }
}

