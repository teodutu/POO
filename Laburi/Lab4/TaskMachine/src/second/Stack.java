package second;

import first.Task;

public class Stack extends AbstractContainer {
    public Stack() {}

    @Override
    public Task pop() {
        try {
            return list.remove(0);
        } catch (Exception e) {
            return null;
        }
    }
}
