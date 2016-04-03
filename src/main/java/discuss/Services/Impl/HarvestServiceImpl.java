package discuss.Services.Impl;

import discuss.Services.HarvestService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired
    HarvestRepository repository;


    @Override
    public String saveHarvest(String harvestDate,
                              double harWeight,
                              String subLocationName,
                              String locationName,
                              String firstname,
                              String lastname,
                              String email,
                              double salary) {
        Person persons = PersonFactory
                .create(firstname, lastname, email);

        Beekeeper beekeepers = BeekeeperFactory
                .create(salary, persons);

        Location locations = LocationFactory
                .create(locationName, beekeepers);
        SubLocation subLocations = SubLocationFactory
                .create(subLocationName, locations);
        Harvest harvests =  HarvestFactory
                .create(harvestDate, harWeight, subLocations);

        return repository.save(harvests).toString();

    }

    @Override
    public Harvest getHarvest (Long id) {

        return repository.findOne(id);
    }
}