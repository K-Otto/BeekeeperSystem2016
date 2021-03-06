package discuss.services;

import discuss.App;
import discuss.Services.SubLocationService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.PersonFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.domain.Person;
import discuss.domain.SubLocation;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by student on 2015/09/24.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SubLocationServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private SubLocation subLocationGlobal;

    @Autowired
    private SubLocationService service;

    @Test
    public void create() throws Exception {
        Person person = PersonFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Beekeeper beekeepers = BeekeeperFactory
                .create(10.00,  person);
        Location locations = LocationFactory
                .create("Darling", beekeepers);
        SubLocation sublocations = SubLocationFactory
                .create("Waterhole", locations);

        service.saveSubLocation(sublocations.getSubLocationName(),
                locations.getLocationName‭‭(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                beekeepers.getSalary‭‭());


        id = sublocations.getId();
        subLocationGlobal = sublocations;
        Assert.assertNotNull(sublocations);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
      //  String idtest = id + "";
      //  Long longId = Long.parseLong(idtest);
      //  SubLocation sublocations = service.getSubLocation(longId);
       // subLocationGlobal = service.getSubLocation(longId);
       // Assert.assertNotNull(subLocationGlobal);
    }

}

