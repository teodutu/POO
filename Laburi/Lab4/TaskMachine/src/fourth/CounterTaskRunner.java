package fourth;

import first.Task;
import third.Strategy;

public class CounterTaskRunner extends AbstractTaskRunner {
    private  int taskCount;

    public CounterTaskRunner(Strategy strategy) {
        super(strategy);
        taskCount = 0;
    }

    @Override
    protected void afterExecution(Task task) {
        ++taskCount;
    }

    public int getCounter() {
        return taskCount;
    }
}
