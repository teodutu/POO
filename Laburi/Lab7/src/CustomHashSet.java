import java.util.Collection;
import java.util.HashSet;

public class CustomHashSet extends HashSet<Integer> {
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
        return super.addAll(c);
    }

    final int getNumElems() {
        return numElems;
    }
}
