import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        QueueInheritance q = new QueueInheritance(5);
//        QueueAggregation q = new QueueAggregation(5);
        Scanner in = new Scanner(System.in);

        try {
            // System.out.println(q.dequeue());
            System.out.println(q.enqueue(in.nextInt()));
            // System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.enqueue(in.nextInt()));
            System.out.println(q.enqueue(in.nextInt()));
            System.out.println(q.enqueue(in.nextInt()));
            // System.out.println(q.dequeue());
            System.out.println(q.enqueue(in.nextInt()));
            System.out.println(q.enqueue(in.nextInt()));
            System.out.println(q.enqueue(in.nextInt()));
            System.out.println(q.enqueue(in.nextInt()));

            for (int i = 0; i < 5; ++i) {
                System.out.println(q.dequeue());
            }
        } catch (Exception e) {
            for (StackTraceElement trace : e.getStackTrace()) {
                System.out.println(trace);
            }
        }
    }
}