package discuss.services;

import discuss.App;
import discuss.Services.HiveService;
import discuss.conf.factories.*;
import discuss.domain.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by student on 2015/09/24.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class HiveServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Hive hiveGlobal;

    @Autowired
    private HiveService service;

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
        Hive hives = HiveFactory
                .create("Active", sublocations);

        service.saveHive(hives.getHiveState(),
                sublocations.getSubLocationName(),
                locations.getLocationName‭‭(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                beekeepers.getSalary‭‭());



        id = hives.getId();
        hiveGlobal = hives;
        Assert.assertNotNull(hives);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
    //    String idtest = id + "";
     //   Long longId = Long.parseLong(idtest);
     //   Hive hives = service.getHive(longId);
      //  hiveGlobal = service.getHive(longId);
      //  Assert.assertNotNull(hiveGlobal);
    }

}
