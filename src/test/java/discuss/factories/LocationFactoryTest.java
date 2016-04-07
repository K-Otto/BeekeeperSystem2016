package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;

import discuss.conf.factories.PersonFactory;
import discuss.domain.Person;
import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;


/**
 * Created by student on 2015/09/13.
 */
public class LocationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);
        Location location = LocationFactory.create("Darling", beekeeper);
        Assert.assertEquals(location.getLocationName‭‭(), "Darling");
    }

    @Test
    public void testUpdate() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeeper = BeekeeperFactory.create(10.00, persons);

        Location location = LocationFactory.create("Cape", beekeeper);
        Assert.assertEquals(location.getLocationName‭‭(), "Cape");
        Location newLocation = new Location
                .Builder‭("Darling")
                .beekeepers(beekeeper)
                .build();
        Assert.assertEquals(newLocation.getLocationName‭‭(),"Darling");


    }
}
