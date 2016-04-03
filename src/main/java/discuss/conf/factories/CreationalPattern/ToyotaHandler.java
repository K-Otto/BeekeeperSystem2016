package discuss.conf.factories.CreationalPattern;

/**
 * Created by student on 2016/04/03.
 */
public class ToyotaHandler extends CarHandler{

    @Override
    public void handleRequest(CarEnum request) {
        if(request == CarEnum.TOYOTA)
            System.out.println("ToyotaHandler handles " + request);
        else System.out.println("Toyota Handler does not handle this " + request);
        if(successor != null){
            successor.handleRequest(request);

        }
    }

}
