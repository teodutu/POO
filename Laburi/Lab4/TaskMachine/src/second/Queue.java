package second;

import first.Task;

public class Queue extends AbstractContainer {
    public Queue() {}

    @Override
    public Task pop() {
        try {
            return list.remove(0);
        } catch (Exception e) {
            return null;
        }
    }
}
