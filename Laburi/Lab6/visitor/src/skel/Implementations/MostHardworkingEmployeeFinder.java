package skel.Implementations;

/**
 * Clasa folosita pentru a vedea daca media numarului de ore suplimentare pentru angajati
 * este mai mare decat cea a managerilor.
 */
public class MostHardworkingEmployeeFinder implements Visitor {

    @Override
    public void visit(Intern intern) {
        System.out.println(intern.getName() + ": 0 hours");
    }

    @Override
    public void visit(Employee employee) {
        System.out.println(employee.getName() + ": " + employee.getExtraHours() + " hours");
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(manager.getName() + ": " + manager.getExtraHours() + " hours");
    }

    public boolean isManagerHardWorking() {
        // TODO

        return false;
    }
}
