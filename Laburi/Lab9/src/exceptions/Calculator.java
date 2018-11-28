package exceptions;

import java.util.Collection;

public class Calculator {
    Integer add(Integer i1, Integer i2) throws OverflowException, UnderflowException {
        if (i2 > Integer.MAX_VALUE - i1) {
            throw new OverflowException("The sum exceeds INT_MAX");
        } else if (Integer.MIN_VALUE - i1 > i2 || Integer.MIN_VALUE - i2 > i1) {
            throw new UnderflowException("The sum is below INT_MIN");
        }

        return i1 + i2;
    }

    Integer divide(Integer i1, Integer i2) {
        return i1 / i2;
    }

    Integer average(Collection<Integer> ints) {
        Integer avg = 0;

        for (Integer num : ints) {
            avg = add(avg, num);
        }

        return divide(avg, ints.size());
    }
}
