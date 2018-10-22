public class QueueAggregation extends Array {
    private Array array;
    private int first = -1, last = -1;

    QueueAggregation(final int maxQ) {
        array = new Array(maxQ);
    }

    int enqueue(int elem) throws Exception {
        int res = array.set(last + 1, elem);
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

        return array.get(first++);
    }
}