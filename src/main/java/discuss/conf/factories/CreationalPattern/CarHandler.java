package discuss.conf.factories.CreationalPattern;

/**
 * Created by student on 2016/04/03.
 */
public abstract class CarHandler {
    CarHandler successor;

    public void setSuccessor(CarHandler successor){
        this.successor = successor;
    }

    public abstract void handleRequest(CarEnum request);
}