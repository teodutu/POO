package bash;

import java.io.File;
import java.nio.file.Paths;

enum Commands {
    CD("cd"),
    LS("ls"),
    ECHO("echo"),
    HISTORY("history");

    private final String text;

    Commands(final String newText) {
        this.text = newText;
    }

    @Override
    public String toString() {
        return text;
    }
}

class BashUtils {
    // Implement some inner classes here: Echo, Cd, Ls, History

    // example: class Cd { ... }

    // Decide if they should be static or non-static.

    // TODO 4 Create Echo class
    static class Echo implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            String currCmd = c.getCommand();

            if (currCmd.startsWith("echo ")) {
                System.out.println(currCmd.substring("echo ".length()));
            }
        }
    }

    // TODO 5 Create Cd class
    static class Cd implements CommandSubscriber{
        @Override
        public void executeCommand(Command c) {
            String currCmd = c.getCommand();

            if (currCmd.startsWith("cd ")) {
                c.getBash().setCurrentDirectory(currCmd.substring("cd ".length()));
            }
        }
    }

    // TODO 6 Create the Ls class
    static class Ls implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().equals("ls")) {
                File[] fileList = c.getBash().getCurrentDirectory().toFile().listFiles();

                if (fileList != null) {
                    for (File currFile : fileList) {
                        System.out.println(currFile.getName());
                    }
                }
            }
        }
    }

    // TODO 7 Create the History class
    static class History implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().equals("history")) {
                System.out.println("History is: " + c.getBash().getHistory());
            }
        }
    }
}
