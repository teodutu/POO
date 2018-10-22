package first;

public class CounterOutTask implements  Task {
    private static int count = 0;

    public CounterOutTask() {
        ++count;
        // execute();
    }

    @Override
    public void execute() {
        System.out.println(count);
    }
}
