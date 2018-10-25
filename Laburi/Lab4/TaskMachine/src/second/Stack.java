package second;

import first.Task;

public class Stack extends AbstractContainer {
    public Stack() {}

    @Override
    public void push(Task task) {
        list.add(0,task);
    }
}
