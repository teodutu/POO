package skel.Implementations;

//TODO implementati interfata Visitable
public class Intern implements Visitable{

    private String  name;
    private int duration;  // in months

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
