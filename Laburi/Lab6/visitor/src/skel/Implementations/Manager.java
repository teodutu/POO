package skel.Implementations;

import java.util.LinkedList;

public class Manager extends Employee {
    private float bonus;

    private LinkedList<Visitable> subordinates = new LinkedList<>();

    Manager(String name, float salary, float bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    Manager(String name, float salary, float extraHours, float bonus) {
        super(name, salary, extraHours);
        this.bonus = bonus;
    }

    float getBonus() {
        return bonus;
    }

    LinkedList<Visitable> getSubordinates() {
        return subordinates;
    }

    void addSubordinate(Visitable subordinate) {
        subordinates.add(subordinate);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
