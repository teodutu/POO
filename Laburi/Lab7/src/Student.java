public class Student implements Comparable<Object> {
    private String name;
    private float grade;

    Student(final String studentName, final float studentGrade) {
        name = studentName;
        grade = studentGrade;
    }

    private String getName() {
        return name;
    }

    final float getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }

        return name.equals(((Student)obj).name) && grade == ((Student)obj).grade;
    }

    boolean equals(Student student) {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + Float.toString(grade);
    }

    @Override
    public int compareTo(Object o) {
       return name.compareTo(((Student)o).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + (int)grade;
    }
}
