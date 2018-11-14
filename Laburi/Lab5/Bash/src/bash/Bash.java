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
    private Bash currInstance;

    public Bash() {
        // TODO 2 Initialize history and currentDirectory;
         history = new StringBuffer();
         currentDirectory = Paths.get(".");

        // TODO 2 Instantiate a new command publisher
         publisher = new BashCommandPublisher();
        currInstance = this;

        // TODO 4 & 5 & 6 & 7
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
            // TODO 3 Read commands from the command line
             String input = scanner.nextLine() ;

            // TODO 3 If we read the "exit" string then we should stop the program.
            if (input.equals(EXIT)) {
                break;
            }

            // TODO 3 Create an anonymous class which extends Thread.
            // It has to implement the 'run' method. From the 'run' method publish the command
            // so that the CommandSubscribers start executing it.
            // Don't forget to start the thread by calling the 'start' method on it!
            Thread thread = new Thread() {
                @Override
                public void run() {
                    publisher.publish(new Command(input, currInstance));
                }
            };

            thread.start();
        }
    }

    // TODO 1: Create an inner class which implements the CommandPublisher interface.
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
