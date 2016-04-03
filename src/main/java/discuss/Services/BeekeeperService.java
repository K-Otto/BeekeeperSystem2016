package discuss.Services;

import discuss.domain.Beekeeper;
import discuss.domain.Person;

/**
 * Created by student on 2015/09/23.
 */
public interface BeekeeperService {
    String saveBeekeeper(double salary,
                        Person person
    );

    Beekeeper getBeekeeper(long id);
}
