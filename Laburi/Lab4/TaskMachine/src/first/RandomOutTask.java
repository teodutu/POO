package first;

import java.util.Random;

public class RandomOutTask implements Task {
    private static Random rand = new Random();
    private final int randInt;

    public RandomOutTask() {
        randInt = rand.nextInt();
    }

    @Override
    public void execute() {
        System.out.println(randInt);
    }
}
