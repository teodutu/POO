package skel.Implementations;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("gigi", 0, 100);
        Manager manager = new Manager("gogu", 100, 0, 1000);

        RevenueVisitor revenueVisitor = new RevenueVisitor();
//        TreeVisitor treeVisitor = new TreeVisitor();
        MostHardworkingEmployeeFinder tractorist = new MostHardworkingEmployeeFinder();

        employee.accept(revenueVisitor);
        employee.accept(tractorist);

        manager.accept(revenueVisitor);
        manager.accept(tractorist);
    }
}
