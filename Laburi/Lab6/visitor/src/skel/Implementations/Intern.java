package skel.Implementations;

<<<<<<< HEAD
=======
//TODO implementati interfata Visitable
>>>>>>> 309f3b06c509f536e19f161dc8bb87e059c2fc37
public class Intern implements Visitable{

    private String  name;
    private int duration;  // in months

<<<<<<< HEAD
    Intern(String slaveName, int slaveDur) {
        name = slaveName;
        duration = slaveDur;
    }

=======
>>>>>>> 309f3b06c509f536e19f161dc8bb87e059c2fc37
    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
