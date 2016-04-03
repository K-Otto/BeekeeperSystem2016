package discuss.respository;

import discuss.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2016/04/03.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}
