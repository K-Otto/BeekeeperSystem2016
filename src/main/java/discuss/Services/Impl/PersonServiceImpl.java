package discuss.Services.Impl;

import discuss.Services.PersonService;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Person;
import discuss.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2016/04/03.
 */

@Service
public class PersonServiceImpl  implements PersonService {
    @Autowired
    PersonRepository repository;


    @Override
    public String savePerson(String firstName,
                                String lastName,
                                String Email) {
        Person beekeepers = PersonFactory
                .create(firstName, lastName, Email);

        return repository.save(beekeepers).toString();

    }

    @Override
    public Person getPerson (long id) {

        return repository.findOne(id);
    }
}
