import java.util.Collection;
import java.util.LinkedList;

public class CustomLinkedList extends LinkedList<Integer> {
    private int numElems;

    @Override
    public boolean add(Integer integer) {
        boolean added = super.add(integer);

        if (added) {
            ++numElems;
        }

        return added;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean added = super.addAll(c);

        if (added) {
            numElems += c.size();
        }

        return added;
    }

    final int getNumElems() {
        return numElems;
    }
}
