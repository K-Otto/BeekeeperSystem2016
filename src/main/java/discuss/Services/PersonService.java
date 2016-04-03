package discuss.Services;

import discuss.domain.Person;

/**
 * Created by student on 2016/04/03.
 */
public interface PersonService {
    String savePerson(String firstName,
                         String lastName,
                         String Email
    );

    Person getPerson(long id);
}
