package second;

import first.Task;
import java.util.ArrayList;

public class Stack implements Container {
    private ArrayList<Task> list;

    public Stack() {
        list = new ArrayList<>();
    }

    @Override
    public Task pop() {
        try {
            return list.remove(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void push(Task task) {
        list.add(0, task);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            push(container.pop());
        }
    }
}
