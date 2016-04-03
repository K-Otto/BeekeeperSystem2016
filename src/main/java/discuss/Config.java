package discuss;

import discuss.conf.factories.BuilderPattern.Person;
import discuss.conf.factories.BuilderPattern.PersonBuilder;
import discuss.conf.factories.BuilderPattern.PersonOne;
import discuss.conf.factories.CreationalPattern.CarHandler;
import discuss.conf.factories.CreationalPattern.NissanHandler;
import discuss.conf.factories.CreationalPattern.ToyotaHandler;
import discuss.conf.factories.FactoryPattern.TransportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/04/03.
 */
@Configuration
public class Config {


    @Bean(name = "builder1")
    public Person builder1() {
        return new Person();
    }

    @Bean(name = "builder2")
    public PersonBuilder builder2() {
        return new PersonOne();
    }
    @Bean (name= "fact")
    public TransportFactory fact()
    {
        return new TransportFactory();
    }
    @Bean (name= "chain1")
    public CarHandler nissan()
    {
        return new NissanHandler();
    }
    @Bean (name= "chain2")
    public CarHandler toyota()
    {
        return new ToyotaHandler();
    }
}