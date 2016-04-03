package discuss.conf.factories.CreationalPattern;

/**
 * Created by student on 2016/04/03.
 */
public class NissanHandler extends CarHandler{

    @Override
    public void handleRequest(CarEnum request) {
        if(request == CarEnum.NISSAN)
            System.out.println("NissanHandler handles " + request);
        else System.out.println("NissanHandler does not handle this " + request);
        if(successor != null){
            successor.handleRequest(request);

        }
    }

}
