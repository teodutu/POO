public class QueueInheritance extends Array {
    private int first = -1, last = -1;

    QueueInheritance(final int maxQ) {
        super(maxQ);
    }

    int enqueue(int elem) throws Exception {
        int res = set(last + 1, elem);
        ++last;

        if (first == -1) {
            first = 0;
        }

        return res;
    }

    int dequeue() throws Exception {
        if (first > last || first == -1) {
            throw new Exception("Error popping value");
        }

        return get(first++);
    }
}