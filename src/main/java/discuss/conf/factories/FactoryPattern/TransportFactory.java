package discuss.conf.factories.FactoryPattern;

/**
 * Created by student on 2016/04/03.
 */
public class TransportFactory {

    public Transport getTransport(String type){
        if("Audi".equals(type)){
            return new Car();
        }else{
            return new Bicycle();
        }
    }

}