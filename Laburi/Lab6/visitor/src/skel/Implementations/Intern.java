package skel.Implementations;

public class Intern implements Visitable{

    private String  name;
    private int duration;  // in months

    Intern(String slaveName, int slaveDur) {
        name = slaveName;
        duration = slaveDur;
    }

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
