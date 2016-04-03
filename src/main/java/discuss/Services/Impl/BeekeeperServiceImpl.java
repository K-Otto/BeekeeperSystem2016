package discuss.Services.Impl;

import discuss.Services.BeekeeperService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.BeekeeperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/23.
 */
@Service
public class BeekeeperServiceImpl  implements BeekeeperService{
    @Autowired
    BeekeeperRepository repository;


    @Override
    public String saveBeekeeper(double salary,
                                Person person) {
        Beekeeper beekeepers = BeekeeperFactory
                .create(salary, person);

        return repository.save(beekeepers).toString();

    }

    @Override
    public Beekeeper getBeekeeper (long id) {

        return repository.findOne(id);
    }
}
