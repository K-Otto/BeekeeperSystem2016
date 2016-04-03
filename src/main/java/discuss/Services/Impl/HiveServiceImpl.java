package discuss.Services.Impl;

import discuss.Services.HiveService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.HiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class HiveServiceImpl implements HiveService{
    @Autowired
    HiveRepository repository;


    @Override
    public String saveHive(String hiveState,
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
        Hive hives = HiveFactory
                .create(hiveState, subLocations);

        return repository.save(hives).toString();

    }

    @Override
    public Hive getHive (Long id) {

        return repository.findOne(id);
    }
}