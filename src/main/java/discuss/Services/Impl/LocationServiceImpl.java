package discuss.Services.Impl;

import discuss.Services.LocationService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.domain.Person;
import discuss.respository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository repository;


    @Override
    public String saveLocation(String locationName,
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

        return repository.save(locations).toString();

    }

    @Override
    public Location getLocation (long id) {

        return repository.findOne(id);
    }
}