package fourth;

import first.Task;
import third.Strategy;
import java.util.Calendar;

public class PrintTimeTaskRunner extends AbstractTaskRunner {
    private Calendar cal;

    public PrintTimeTaskRunner(Strategy strategy) {
        super(strategy);
        cal = Calendar.getInstance();
    }

    @Override
    protected void afterExecution(Task task) {
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
    }
}
