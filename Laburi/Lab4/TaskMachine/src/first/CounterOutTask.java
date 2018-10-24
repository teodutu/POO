package first;

public class CounterOutTask implements  Task {
    private static int count = 0;

    public CounterOutTask() {}

    @Override
    public void execute() {
        ++count;
        System.out.println(count);
    }
}
