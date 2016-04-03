package discuss.conf.factories.SingletonPattern;

/**
 * Created by student on 2016/04/03.
 */
public class Student {

    private static Student myStudent;
    private String name = "Test";

    private Student()
    {

    }

    public synchronized static Student instance(){
        if(myStudent == null){
            myStudent = new Student();
        }
        return myStudent;
    }

    public String getName(){
        return name;
    }

}