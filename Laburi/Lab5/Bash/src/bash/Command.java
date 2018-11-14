package bash;

class Command {
    private Bash bash;
    private String command;

    Command(final String newCommand, final Bash newBash) {
        this.bash = newBash;
        this.command = newCommand;
    }

    final Bash getBash() {
        return bash;
    }

    final String getCommand() {
        return command;
    }
}
