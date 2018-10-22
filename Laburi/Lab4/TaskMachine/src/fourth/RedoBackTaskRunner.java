package fourth;

import first.Task;
import second.Stack;
import third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {
    private Stack st;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        st = new Stack();
    }

    @Override
    protected void afterExecution(Task task) {
        st.push(task);
    }

    public void redo() {
        while (!st.isEmpty()) {
            st.pop().execute();
        }
    }
}
