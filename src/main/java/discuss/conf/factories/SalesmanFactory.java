package discuss.conf.factories;

import discuss.domain.Person;
import discuss.domain.Salesman;

/**
 * Created by student on 2016/04/07.
 */
public class SalesmanFactory {
    public static Salesman create(double salary, Person persons){
        Salesman salesman = new Salesman.Builder‭(salary)
                .persons(persons)
                .build();
        return salesman ;
    }
}

