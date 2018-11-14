package skel.Implementations;

/**
 * Clasa folosita pentru a vedea daca media numarului de ore suplimentare pentru angajati
 * este mai mare decat cea a managerilor.
 */
public class MostHardworkingEmployeeFinder implements Visitor {
    private int numEmployees, numManagers;
    private float empHours, mngrHours;

    MostHardworkingEmployeeFinder() {
        numEmployees = numManagers = 0;
        empHours = mngrHours = 0;
    }

    @Override
    public void visit(Intern intern) {
        System.out.println(intern.getName() + ": 0 hours");
    }

    @Override
    public void visit(Employee employee) {
        float currHours = employee.getExtraHours();

        System.out.println(employee.getName() + ": " + currHours + " hours");

        ++numEmployees;
        empHours += currHours;
    }

    @Override
    public void visit(Manager manager) {
        float currHours = manager.getExtraHours();

        System.out.println(manager.getName() + ": " + currHours + " hours");

        ++numManagers;
        empHours += currHours;
    }

    boolean isManagerHardWorking() {
        return mngrHours / numManagers > empHours / numEmployees;
    }
}
