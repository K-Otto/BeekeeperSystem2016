package discuss.conf.factories;

import discuss.domain.Person;

/**
 * Created by student on 2016/04/03.
 */
public class PersonFactory {
    public static Person create(String firstName, String lastName, String email){
        Person persons = new Person.Builder(lastName)
                .firstName(firstName)
                .email(email)
                .build();
        return persons ;
    }
}