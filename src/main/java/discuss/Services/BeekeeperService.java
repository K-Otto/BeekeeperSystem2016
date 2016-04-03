package discuss.Services;

import discuss.domain.Beekeeper;
import discuss.domain.Person;

/**
 * Created by student on 2015/09/23.
 */
public interface BeekeeperService {
    String saveBeekeeper(String firstname,
                         String lastname,
                         String email,
                         double salary


    );

    Beekeeper getBeekeeper(long id);
}
