package discuss.repositories;

import discuss.App;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.HiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;




import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class HiveCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private HiveRepository repository;

    @Test
    public void create() throws Exception {
        Person persons = PersonFactory.create("karl", "otto", "karl1256@yahoo.com");
        Beekeeper beekeepers = BeekeeperFactory.create(10.00, persons);
        Location locations = LocationFactory.create("Darling", beekeepers);


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);

        Hive role = HiveFactory.create("Active", subLocations);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Hive role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
      ;
        Hive role = repository.findOne(id);
        Hive newrole = new Hive
                .Builder(role.getHiveState())
                .copy(role)
                .subLocations(role.getSubLocation())
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Hive savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getHiveState(),"Active");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Hive role = repository.findOne(id);
        repository.delete(role);
        Hive deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}