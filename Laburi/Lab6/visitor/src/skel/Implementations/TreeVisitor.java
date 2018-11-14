package skel.Implementations;

/**
 * Clasa folosita pentru a parcurge o structura ierarhica / arborescenta - separa doua
 * concepte: un obiect de tipul visitor ce realizeaza operatii pe un set de date
 * (ex. calculeaza media orelor suplimentare) si acest tip de visitor (TreeVisitor)
 * ce parcurge nodurile structurii arborescente si aplica visitor-ul ce realizeaza operatii
 * (prezentat anterior).
 */
public class TreeVisitor implements Visitor {
    private Visitor baseVisitor;

    TreeVisitor(Visitor baseVisitor) {
        this.baseVisitor = baseVisitor;
    }

    @Override
    public void visit(Intern intern) {
        intern.accept(baseVisitor);
    }

    @Override
    public void visit(Employee employee) {
        employee.accept(baseVisitor);
    }

    @Override
    public void visit(Manager manager) {
        manager.accept(baseVisitor);

        for (Visitable worker : manager.getSubordinates()) {
            if (worker instanceof Intern) {
                visit((Intern)worker);
            } else if (worker instanceof Manager) {
                visit((Manager)worker);
            } else if (worker instanceof Employee) {
                visit((Employee)worker);
            }
        }
    }

    Visitor getBaseVisitor() {
        return baseVisitor;
    }
}