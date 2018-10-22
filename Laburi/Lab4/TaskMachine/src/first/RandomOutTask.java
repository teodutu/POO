package first;

import java.util.Random;

public class RandomOutTask implements Task {
    private static Random rand = new Random();

    public RandomOutTask() {}

    @Override
    public void execute() {
        System.out.println(rand.nextInt());
    }
}
