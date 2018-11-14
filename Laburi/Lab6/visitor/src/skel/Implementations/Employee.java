package skel.Implementations;

public class Employee implements Visitable {
    private String name;
    private float salary;
    private float extraHours;


    Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee(String name, float salary, float  extraHours) {
        this(name, salary);
        this.extraHours = extraHours;
    }

    String getName() {
        return name;
    }


    float getSalary() {
        return salary;
    }

    float getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
