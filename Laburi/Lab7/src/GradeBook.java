import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Collections;

class GradeBook extends TreeMap<Integer, List<Student>>{
    GradeBook(Comparator<? super Integer> comparator) {
        super(comparator);
    }

    void add(Student s) {
        int studentGrade = Math.round(s.getGrade());
        List<Student> l = get(studentGrade);

        if (l == null) {
            l = new ArrayList<>();
        }

        l.add(s);
        put(studentGrade, l);
    }

    void sortStudents() {
        for (Map.Entry<Integer, List<Student>> pair : super.entrySet()) {
            Collections.sort(pair.getValue());
        }
    }
}
