package third;

import second.Container;
import second.Queue;
import second.Stack;

public class ContainerFactory implements IFactory {
    public static final ContainerFactory INSTANCE = new ContainerFactory();

    private ContainerFactory() {}

    public Container createContainer(Strategy strategy) {
        switch (strategy) {
            case FIFO:
                return new Queue();
            case LIFO:
                return new Stack();
        }

        return null;
    }
}