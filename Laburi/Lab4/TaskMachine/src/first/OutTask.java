package first;

public class OutTask implements Task {
    private String message;

    public OutTask (String msg) {
        message = msg;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}