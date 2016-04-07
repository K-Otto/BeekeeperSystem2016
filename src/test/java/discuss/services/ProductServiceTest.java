package discuss.services;

import discuss.App;
import discuss.Services.BucketService;
import discuss.conf.factories.*;
import discuss.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ProductServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Product productGlobal;

    @Autowired
    private BucketService service;

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
        Harvest harvests = HarvestFactory
                .create("December", 22.00, sublocations);
        Product buckets = ProductFactory
                .create(22.00, harvests);


        service.saveBucket(
                buckets.getTotalStock(),
                harvests.getHarvestDate(),
                harvests.getWeight(),
                sublocations.getSubLocationName(),
                locations.getLocationName‭‭(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                beekeepers.getSalary‭‭()
               );


        id = buckets.getId();
        productGlobal = buckets;
        Assert.assertNotNull(buckets);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
      //  String idtest = id + "";
      //  Long longId = Long.parseLong(idtest);
      //  Product buckets = service.getBucket(longId);
      //  productGlobal = service.getBucket(longId);
      //  Assert.assertNotNull(productGlobal);
    }

}
