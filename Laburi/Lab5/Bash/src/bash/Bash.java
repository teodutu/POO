package bash;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public final class Bash {
    private Path currentDirectory;
    private StringBuffer history;

    private CommandPublisher publisher;
    private static final String EXIT = "exit";

    public Bash() {
        history = new StringBuffer();
        currentDirectory = Paths.get(".");

        publisher = new BashCommandPublisher();

        // CommandSubscribers know how to execute the commands.
        // Subscribe some to the Command publisher.
        publisher.subscribe(new BashUtils.Echo());
        publisher.subscribe(new BashUtils.Cd());
        publisher.subscribe(new BashUtils.Ls());
        publisher.subscribe(new BashUtils.History());
    }

    void setCurrentDirectory(String extraPath) {
        currentDirectory = Paths.get(currentDirectory.toString() + "/" + extraPath);
    }

    Path getCurrentDirectory() {
        return currentDirectory;
    }

    StringBuffer getHistory() {
        return history;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
             String input = scanner.nextLine() ;

            if (input.equals(EXIT)) {
                break;
            }

            // It has to implement the 'run' method. From the 'run' method publish the command
            // so that the CommandSubscribers start executing it.
            // Don't forget to start the thread by calling the 'start' method on it!
            Thread thread = new Thread(() -> publisher.publish(new Command(input, Bash.this)));
            thread.start();
        }
    }

    // 1. The class should contain an ArrayList of CommandSubscribers
    // 2. The class should implement the subscribe and publish methods.
    class BashCommandPublisher implements CommandPublisher {
        ArrayList<CommandSubscriber> cmdSubs;

        BashCommandPublisher() {
            cmdSubs = new ArrayList<>();
        }

        @Override
        public void subscribe(CommandSubscriber subscriber) {
            cmdSubs.add(subscriber);
        }

        @Override
        public void publish(Command command) {
            if (history.length() == 0) {
                history.append(command.getCommand());
            } else {
                history.append(" | | ").append(command.getCommand());
            }

            for (CommandSubscriber currSubscriber : cmdSubs) {
                currSubscriber.executeCommand(command);
            }
        }
    }

}
