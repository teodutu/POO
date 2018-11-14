import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> set = new HashSet<>();

        CustomHashSet customSet = new CustomHashSet();
        CustomLinkedList customList = new CustomLinkedList();
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(8);
        arr.add(13);
        customSet.addAll(arr);
        customList.addAll(arr);

        arr.clear();
        arr.add(13);
        arr.add(21);
        customSet.addAll(arr);
        customList.addAll(arr);

        customSet.add(34);
        customList.add(34);

        System.out.println(customSet.getNumElems());
        System.out.println(customList.getNumElems());

        for (int i = 0; i < 3; ++i) {
            Student student = new Student(sc.next(), sc.nextFloat());
            System.out.println(student.hashCode());

            if (!set.add(student)) {
                System.out.println("Studentul deja exista");
            }
        }

        for (Student currStudent : set) {
            System.out.println(currStudent);
        }

        for (Student currStudent : set) {
            System.out.println(currStudent.equals(currStudent));
        }

        for (Student currStudent : set) {
            System.out.println(((Object)currStudent).equals(currStudent));
        }

        GradeBook gradeBook = new GradeBook(Comparator.comparingInt(Math::round));

        for (int i = 0; i < 5; ++i) {
            gradeBook.add(new Student(sc.next(), sc.nextFloat()));
        }

        gradeBook.sortStudents();

        for (Map.Entry<Integer, List<Student>> currGrade : gradeBook.entrySet()) {
            System.out.println(currGrade.getKey());

            for (Student currStudent : currGrade.getValue()) {
                System.out.println(currStudent);
            }
        }
    }
}
