package bash;

import java.io.File;
import java.nio.file.Paths;

enum Commands {
    CD("cd "),
    LS("ls"),
    ECHO("echo "),
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

    static class Echo implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            String currCmd = c.getCommand();

            if (currCmd.startsWith(Commands.ECHO.toString())) {
                System.out.println(currCmd.substring(Commands.ECHO.toString().length()));
            }
        }
    }

    static class Cd implements CommandSubscriber{
        @Override
        public void executeCommand(Command c) {
            String currCmd = c.getCommand();

            if (currCmd.startsWith(Commands.CD.toString())) {
                c.getBash().setCurrentDirectory(currCmd.substring(Commands.CD.toString().length()));
            }
        }
    }

    static class Ls implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().equals(Commands.LS.toString())) {
                File[] fileList = c.getBash().getCurrentDirectory().toFile().listFiles();

                if (fileList != null) {
                    for (File currFile : fileList) {
                        System.out.println(currFile.getName());
                    }
                }
            }
        }
    }

    static class History implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().equals(Commands.HISTORY.toString())) {
                System.out.println("History is: " + c.getBash().getHistory());
            }
        }
    }
}
