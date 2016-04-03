package discuss.conf.factories;

import discuss.domain.Beekeeper;
import discuss.domain.Person;

/**
 * Created by student on 2015/09/13.
 */
public class BeekeeperFactory {
    public static Beekeeper create(double salary, Person persons){
        Beekeeper beekeepers = new Beekeeper.Builder‭(salary)
                .persons(persons)
                .build();
        return beekeepers ;
    }
}
