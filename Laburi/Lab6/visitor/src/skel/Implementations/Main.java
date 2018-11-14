package skel.Implementations;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("clara", 0, 100);
        Manager manager = new Manager("root", 100, 0, 1000);
        Manager river = new Manager("river", 100, 20);

        RevenueVisitor revenueVisitor = new RevenueVisitor();
        MostHardworkingEmployeeFinder tractorist = new MostHardworkingEmployeeFinder();
        TreeVisitor treeVisitor = new TreeVisitor(tractorist);


        employee.accept(revenueVisitor);
        manager.accept(revenueVisitor);
        System.out.println("\n");

        river.addSubordinate(new Employee("rory", 2, 100));
        river.addSubordinate(new Employee("amy", 2, 100));
        river.addSubordinate(new Intern("gigel", 8));

        manager.addSubordinate(employee);
        manager.addSubordinate(river);

        manager.accept(treeVisitor);
        System.out.println(((MostHardworkingEmployeeFinder)treeVisitor.getBaseVisitor()).isManagerHardWorking());
        System.out.println("\n");

        FilesCounter filesCounter = new FilesCounter();

        try {
            Files.walkFileTree(Paths.get("."), filesCounter);

            for (Path currJavaFile : filesCounter.getJavaFiles()) {
                System.out.println(currJavaFile.getFileName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
