package discuss.services;
import discuss.App;
import discuss.Services.BeekeeperService;
import discuss.conf.factories.*;
import discuss.domain.*;
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
public class BeekeeperServiceTest  extends AbstractTestNGSpringContextTests {

        private Long id;
        private Beekeeper beekeeperGlobal;

        @Autowired
        private BeekeeperService service;

        @Test
        public void create() throws Exception {
            Person person = PersonFactory
                    .create("Karl", "Otto", "Karl@gmail.com");
            Beekeeper beekeepers = BeekeeperFactory
                    .create(10.00,  person);

            service.saveBeekeeper(
                    person.getFirstName(),
                    person.getLastName(),
                    person.getEmail(),
                    beekeepers.getSalary‭‭());


            id = beekeepers.getBeekeeperID();
            beekeeperGlobal = beekeepers;
            Assert.assertNotNull(beekeepers);
        }

        @Test(dependsOnMethods = "create")
        public void read() throws Exception {
            // Get subject
            //   String idtest = id + "";
            //   Long longId = Long.parseLong(idtest);
            //   Location locations = service.getLocation(1);
            //   id = locations.getLocID();
            //  locationGlobal = service.getLocation(id);
            //  Assert.assertNotNull(locationGlobal);
        }

    }




