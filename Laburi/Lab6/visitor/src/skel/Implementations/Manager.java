package skel.Implementations;

import java.util.LinkedList;

public class Manager extends Employee {
    protected float bonus;

    private LinkedList<Visitable> subordinates = new LinkedList<Visitable>();

    public Manager(String name, float salary, float bonus) {
        super(name, salary);

        this.bonus = bonus;
    }

    public Manager(String name, float salary, float extraHours, float bonus) {
        super(name, salary, extraHours);

        this.bonus = bonus;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public LinkedList<Visitable> getSubordinates() {
        //TODO

        return subordinates;
    }

    public void addSubordinate(Visitable subordinate) {
        //TODO
        subordinates.add(subordinate);
    }

    //TODO ex1b - nu mai suprascrieti metoda accept
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
